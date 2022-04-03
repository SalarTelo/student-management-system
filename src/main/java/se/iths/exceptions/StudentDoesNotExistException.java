package se.iths.exceptions;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class StudentDoesNotExistException extends WebApplicationException {

    public StudentDoesNotExistException(long id) {
        super(Response.status(Response.Status.NOT_FOUND).entity("Student with ID " + id + " was not found in database.").type(MediaType.TEXT_PLAIN_TYPE).build());
    }
}
