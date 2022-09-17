package dev.ifrs;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jboss.resteasy.annotations.jaxrs.FormParam;

@Path("/bff")
public class GreetingResource {

    @POST
    @Path("/sum")
    @RolesAllowed({ "user" })
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.TEXT_PLAIN)
    public int sum(@FormParam("a") int a, @FormParam("b") int b) {
        return a + b;
    }
}