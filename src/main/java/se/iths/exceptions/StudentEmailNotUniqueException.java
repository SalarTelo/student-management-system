package se.iths.exceptions;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class StudentEmailNotUniqueException extends WebApplicationException {

    public StudentEmailNotUniqueException(String mail) {
        super(Response.status(Response.Status.PRECONDITION_FAILED).entity("A student with the mail: " + mail + " already exists...").type(MediaType.TEXT_PLAIN_TYPE).build());
    }
}
