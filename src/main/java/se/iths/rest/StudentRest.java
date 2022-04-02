package se.iths.rest;


import se.iths.entity.Student;
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

    @Path("")
    @POST
    public Response createStudent(Student data){
        service.createStudent(data);
        return Response.ok(data).build();
    }

    @Path("")
    @PUT
    public Response updateStudent(Student data){
        service.updateStudent(data);
        return Response.ok(data).build();
    }

    @Path("{id}")
    @GET
    public Response findStudentById(@PathParam("id") Long id){
        Student student = service.findStudentById(id);
        if (student == null) {

            throw new WebApplicationException(Response.status(Response.Status.NOT_FOUND)
                    .entity("Student with ID " + id + " was not found in database.").type(MediaType.TEXT_PLAIN_TYPE).build());
        }
        return Response.ok(student).build();
    }

    @Path("")
    @GET
    public Response getAllStudents(){
        List<Student> students = service.getAllStudents();
        return Response.ok(students).build();
    }


    @Path("{id}")
    @DELETE
    public Response deleteStudent(@PathParam("id") Long id){
        service.deleteStudent(id);
        return Response.ok().build();
    }

}
