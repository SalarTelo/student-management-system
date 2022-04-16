package se.iths.rest;


import se.iths.entity.Subject;
import se.iths.service.StudentService;
import se.iths.service.SubjectService;
import se.iths.service.TeacherService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("subjects")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class SubjectRest {

    SubjectService subjectService;
    StudentService studentService;
    TeacherService teacherService;

    @Inject
    public SubjectRest(SubjectService subjectService, StudentService studentService, TeacherService teacherService){
        this.subjectService = subjectService;
        this.studentService = studentService;
        this.teacherService = teacherService;
    }

    @Path("{id}")
    @DELETE
    public Response deleteSubject(@PathParam("id") Long id){
        Subject subject = subjectService.findSubjectById(id);
        if(subject == null){
            var errMessage = new Object(){
                public String status = "NOT_FOUND";
                public String message = "Subject does not exist";
            };
            throw new WebApplicationException(Response.status(Response.Status.NOT_FOUND).entity(errMessage).type(MediaType.APPLICATION_JSON).build());
        }
        subjectService.deleteSubject(subject);
        return Response.ok().build();
    }

    @POST
    public Response createSubject(Subject data){
        subjectService.createSubject(data);
        return Response.ok(data).build();
    }

    @PUT
    public Response updateSubject(Subject data){
        Subject subject = subjectService.findSubjectById(data.getId());
        if(subject == null){
            var errMessage = new Object(){
                public String status = "NOT_FOUND";
                public String message = "Subject does not exist";
            };
            throw new WebApplicationException(Response.status(Response.Status.NOT_FOUND).entity(errMessage).type(MediaType.APPLICATION_JSON).build());
        }
        subjectService.updateSubject(data);
        return Response.ok(data).build();
    }

    @GET
    public Response getAllSubjects(){
        List<Subject> subjects = subjectService.getAllSubjects();
        return Response.ok(subjects).build();
    }

    @Path("{id}")
    @GET
    public Response findSubjectById(@PathParam("id") Long id){
        Subject subject = subjectService.findSubjectById(id);
        if(subject == null){
            var errMessage = new Object(){
                public String status = "NOT_FOUND";
                public String message = "Subject does not exist";
            };
            throw new WebApplicationException(Response.status(Response.Status.NOT_FOUND).entity(errMessage).type(MediaType.APPLICATION_JSON).build());
        }
        return Response.ok(subject).build();
    }

    @Path("{subjectId}/students/{studentId}")
    @POST
    public Response addStudent(@PathParam("subjectId")Long subjectId, @PathParam("studentId")Long studentId){
        var subject = subjectService.findSubjectById(subjectId);
        if(subject == null){
            var errMessage = new Object(){
                public String status = "NOT_FOUND";
                public String message = "Subject does not exist";
            };
            throw new WebApplicationException(Response.status(Response.Status.NOT_FOUND).entity(errMessage).type(MediaType.APPLICATION_JSON).build());
        }
        var student = studentService.findStudentById(studentId);
        if(student == null){
            var errMessage = new Object(){
                public String status = "NOT_FOUND";
                public String message = "Student does not exist";
            };
            throw new WebApplicationException(Response.status(Response.Status.NOT_FOUND).entity(errMessage).type(MediaType.APPLICATION_JSON).build());
        }
        var updateSubject =  subjectService.addStudent(subject, student);
        return Response.ok(updateSubject).build();
    }

    @Path("{subjectId}/students/{studentId}")
    @DELETE
    public Response removeStudent(@PathParam("subjectId")Long subjectId, @PathParam("studentId")Long studentId){
        var subject = subjectService.findSubjectById(subjectId);
        if(subject == null){
            var errMessage = new Object(){
                public String status = "NOT_FOUND";
                public String message = "Subject does not exist";
            };
            throw new WebApplicationException(Response.status(Response.Status.NOT_FOUND).entity(errMessage).type(MediaType.APPLICATION_JSON).build());
        }
        var student = studentService.findStudentById(studentId);
        if(student == null){
            var errMessage = new Object(){
                public String status = "NOT_FOUND";
                public String message = "Student does not exist";
            };
            throw new WebApplicationException(Response.status(Response.Status.NOT_FOUND).entity(errMessage).type(MediaType.APPLICATION_JSON).build());
        }

        var updateSubject = subjectService.removeStudent(subject, student);
        return Response.ok(updateSubject).build();
    }


    @Path("{subjectId}/teacher/{teacherId}")
    @PUT
    public Response setTeacher(@PathParam("subjectId")Long subjectId, @PathParam("teacherId")Long teacherId) {
        var subject = subjectService.findSubjectById(subjectId);
        if(subject == null){
            var errMessage = new Object(){
                public String status = "NOT_FOUND";
                public String message = "Subject does not exist";
            };
            throw new WebApplicationException(Response.status(Response.Status.NOT_FOUND).entity(errMessage).type(MediaType.APPLICATION_JSON).build());
        }
        var teacher = teacherService.findTeacherById(teacherId);
        if(teacher == null){
            var errMessage = new Object(){
                public String status = "NOT_FOUND";
                public String message = "Teacher does not exist";
            };
            throw new WebApplicationException(Response.status(Response.Status.NOT_FOUND).entity(errMessage).type(MediaType.APPLICATION_JSON).build());
        }
        var updatedSubject = subjectService.setTeacher(subject, teacher);
        return Response.ok(updatedSubject).build();
    }
}
