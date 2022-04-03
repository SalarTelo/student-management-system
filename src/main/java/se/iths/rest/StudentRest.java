package se.iths.rest;


import se.iths.entity.Student;
import se.iths.exceptions.StudentEmailNotUniqueException;
import se.iths.exceptions.StudentDoesNotExistException;
import se.iths.service.StudentService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("students")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class StudentRest {

    StudentService service;

    @Inject
    public StudentRest(StudentService service){
        this.service = service;
    }

    @POST
    public Response createStudent(Student data){
        var students = service.findStudentByEmail(data.getEmail());
        if(students.size() > 0){
            throw new StudentEmailNotUniqueException(data.getEmail());
        }
        service.createStudent(data);
        return Response.ok(data).build();
    }

    @PUT
    public Response updateStudent(Student data){
        var students = service.findStudentByEmail(data.getEmail());
        if(students.size() > 0){
            throw new StudentEmailNotUniqueException(data.getEmail());
        }
        service.updateStudent(data);
        return Response.ok(data).build();
    }

    @Path("{id}")
    @GET
    public Response findStudentById(@PathParam("id") Long id){
        Student student = service.findStudentById(id);
        if (student == null) {
            throw new StudentDoesNotExistException(id);
        }
        return Response.ok(student).build();
    }

    @Path("query")
    @GET
    public Response findStudentByLastName(@QueryParam("lastName") String lastName){
        List<Student> students = service.findStudentsByLastName(lastName);
        return Response.ok(students).build();
    }


    @GET
    public Response getAllStudents(){
        List<Student> students = service.getAllStudents();
        return Response.ok(students).build();
    }


    @Path("{id}")
    @DELETE
    public Response deleteStudent(@PathParam("id") Long id){
        Student student = service.findStudentById(id);
        if (student == null) {
            throw new StudentDoesNotExistException(id);
        }
        service.deleteStudent(id);
        return Response.ok().build();
    }

}
