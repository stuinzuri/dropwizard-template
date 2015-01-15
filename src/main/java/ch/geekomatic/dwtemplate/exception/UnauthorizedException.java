package ch.geekomatic.dwtemplate.exception;

import static javax.ws.rs.core.HttpHeaders.WWW_AUTHENTICATE;
import static javax.ws.rs.core.Response.Status.UNAUTHORIZED;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
 
/** Throw this exception to return a 401 Unauthorized response.  The WWW-Authenticate header is
 * set appropriately and a short message is included in the response entity. */
@SuppressWarnings("serial")
public class UnauthorizedException extends WebApplicationException
{
    public UnauthorizedException()
    {
        this("Please authenticate.", "Adherence API");
    }
 
    public UnauthorizedException(String message, String realm)
    {
        super(Response.status(UNAUTHORIZED)
        		      .header(WWW_AUTHENTICATE, String.format("Basic realm=\"%s\"", realm))
                      .entity(message)
                      .build());
    }
}
