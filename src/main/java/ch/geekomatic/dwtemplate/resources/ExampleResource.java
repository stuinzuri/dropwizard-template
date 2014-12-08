package ch.geekomatic.dwtemplate.resources;

import ch.geekomatic.dwtemplate.core.ReadOnlyDomainObject;

import com.google.common.base.Optional;
import com.codahale.metrics.annotation.Timed;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import java.util.concurrent.atomic.AtomicLong;

@Path("/example")
@Produces(MediaType.APPLICATION_JSON)
public class ExampleResource {
    private final String template;
    private final String defaultName;
    private final AtomicLong counter;

    public ExampleResource(String template, String defaultName) {
        this.template = template;
        this.defaultName = defaultName;
        this.counter = new AtomicLong();
    }

    @GET
    @Timed
    public ReadOnlyDomainObject exampleMethod(@QueryParam("name") Optional<String> name) {
        final String value = String.format(template, name.or(defaultName));
        return new ReadOnlyDomainObject(counter.incrementAndGet(), value);
    }
}
