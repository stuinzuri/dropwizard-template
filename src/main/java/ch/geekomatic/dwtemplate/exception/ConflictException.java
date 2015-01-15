package ch.geekomatic.dwtemplate.exception;

import static javax.ws.rs.core.Response.Status.CONFLICT;

import java.net.URI;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
 
/** Thrown to return a 409 Conflict response with optional Location header and entity. */
@SuppressWarnings("serial")
public class ConflictException extends WebApplicationException
{
 
    public ConflictException()
    {
        this(null, null);
    }
 
    public ConflictException(URI location)
    {
        this(location, null);
    }
 
    public ConflictException(URI location, Object entity)
    {
        super(Response.status(CONFLICT)
        		      .location(location)
        		      .entity(entity)
        		      .build());
    }
}
