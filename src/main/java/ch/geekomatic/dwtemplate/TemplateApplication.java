package ch.geekomatic.dwtemplate;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import ch.geekomatic.dwtemplate.health.TemplateHealthCheck;
import ch.geekomatic.dwtemplate.resources.ExampleResource;

public class TemplateApplication extends Application<AppConfiguration> {
    public static void main(String[] args) throws Exception {
        new TemplateApplication().run(args);
    }

    @Override
    public String getName() {
        return "dropwizard-template";
    }

    @Override
    public void initialize(Bootstrap<AppConfiguration> bootstrap) {
        //TODO
    }


    @Override
    public void run(AppConfiguration configuration, Environment environment) {
    	//resources
        final ExampleResource resource = new ExampleResource(
            configuration.getTemplate(),
            configuration.getDefaultName()
        );
        
        //health checks
        final TemplateHealthCheck healthCheck = new TemplateHealthCheck(
        	configuration.getTemplate()
        );
        
        //register them
        environment.healthChecks().register("template", healthCheck);
        environment.jersey().register(resource);
    }
    
}
