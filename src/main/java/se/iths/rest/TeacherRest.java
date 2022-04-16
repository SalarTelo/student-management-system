package se.iths.rest;


import se.iths.entity.Teacher;
import se.iths.service.StudentService;
import se.iths.service.TeacherService;
import se.iths.service.TeacherService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("teachers")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TeacherRest {

    TeacherService teacherService;

    @Inject
    public TeacherRest(TeacherService teacherService){
        this.teacherService = teacherService;
    }

    @Path("{id}")
    @DELETE
    public Response deleteTeacher(@PathParam("id") Long id){
        var teacher = teacherService.findTeacherById(id);
        if(teacher == null){
            var errMessage = new Object(){
                public String status = "NOT_FOUND";
                public String message = "Teacher does not exist";
            };
            throw new WebApplicationException(Response.status(Response.Status.NOT_FOUND).entity(errMessage).type(MediaType.APPLICATION_JSON).build());
        }
        teacherService.removeTeacher(teacher);
        return Response.ok().build();
    }
    @POST
    public Response createTeacher(Teacher teacherBody){
        var teacher = teacherService.createTeacher(teacherBody);
        return Response.ok(teacher).build();
    }

    @Path("{id}")
    @PUT
    public Response updateTeacher(Teacher teacherBody, @PathParam("id")Long id){
        var teacher = teacherService.findTeacherById(id);
        if(teacher == null){
            var errMessage = new Object(){
                public String status = "NOT_FOUND";
                public String message = "Teacher does not exist";
            };
            throw new WebApplicationException(Response.status(Response.Status.NOT_FOUND).entity(errMessage).type(MediaType.APPLICATION_JSON).build());
        }
        teacherBody.setId(id);
        var updatedTeacher = teacherService.updateTeacher(teacherBody);
        return Response.ok(updatedTeacher).build();
    }
    @GET
    public Response getAllTeachers(){
        var result = teacherService.getAllTeachers();
        return Response.ok(result).build();
    }

    @Path("{id}")
    @GET
    public Response findTeacherById(@PathParam("id") Long id){
        var teacher = teacherService.findTeacherById(id);
        if(teacher == null){
            var errMessage = new Object(){
                public String status = "NOT_FOUND";
                public String message = "Teacher does not exist";
            };
            throw new WebApplicationException(Response.status(Response.Status.NOT_FOUND).entity(errMessage).type(MediaType.APPLICATION_JSON).build());
        }
        return Response.ok(teacher).build();
    }

}
