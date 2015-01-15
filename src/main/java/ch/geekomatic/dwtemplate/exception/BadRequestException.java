package ch.geekomatic.dwtemplate.exception;

import java.util.Arrays;
import java.util.List;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.GenericEntity;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import javax.ws.rs.core.Response;
import static javax.ws.rs.core.Response.Status.BAD_REQUEST;
 
/** Thrown to return a 400 Bad Request response with a list of error messages in the body. */
@SuppressWarnings("serial")
public class BadRequestException extends WebApplicationException
{
    private List<String> errors;
 
    public BadRequestException(String... errors)
    {
        this(Arrays.asList(errors));
    }
 
    public BadRequestException(List<String> errors)
    {
        super(Response.status(BAD_REQUEST)
        		      .type(APPLICATION_JSON)
                      .entity(new GenericEntity<List<String>>(errors){})
                      .build());
        
        this.errors = errors;
    }
 
    public List<String> getErrors()
    {
        return errors;
    }
}
