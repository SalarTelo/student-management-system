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

    StudentService studentService;

    @Inject
    public StudentRest(StudentService service){
        this.studentService = service;
    }

    @POST
    public Response createStudent(Student data){
        var students = studentService.findStudentByEmail(data.getEmail());
        if(students.size() > 0){
            throw new StudentEmailNotUniqueException(data.getEmail());
        }
        studentService.createStudent(data);
        return Response.ok(data).build();
    }

     @PUT
    public Response updateStudent(Student data){
        var students = studentService.findStudentByEmail(data.getEmail());

        //Does another student already have use this mail?
        if(students.size() > 0 && !students.get(0).getId().equals(data.getId())){
            throw new StudentEmailNotUniqueException(data.getEmail());
        }

        studentService.updateStudent(data);
        return Response.ok(data).build();
    }

    @Path("{id}")
    @GET
    public Response findStudentById(@PathParam("id") Long id){
        Student student = studentService.findStudentById(id);
        if (student == null) {
            throw new StudentDoesNotExistException(id);
        }
        return Response.ok(student).build();
    }

    @Path("query")
    @GET
    public Response findStudentByLastName(@QueryParam("lastName") String lastName){
        List<Student> students = studentService.findStudentsByLastName(lastName);
        return Response.ok(students).build();
    }


    @GET
    public Response getAllStudents(){
        List<Student> students = studentService.getAllStudents();
        return Response.ok(students).build();
    }


    @Path("{id}")
    @DELETE
    public Response deleteStudent(@PathParam("id") Long id){
        Student student = studentService.findStudentById(id);
        if (student == null) {
            throw new StudentDoesNotExistException(id);
        }
        studentService.deleteStudent(student);
        return Response.ok(studentService.getAllStudents()).build();
    }

}
