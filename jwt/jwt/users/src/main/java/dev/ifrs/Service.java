package dev.ifrs;

import java.util.Arrays;
import java.util.HashSet;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.jwt.Claims;

import io.smallrye.jwt.build.Jwt;

@Path("/users")
public class Service {

    @Path("/jwt")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String generateJwt(){
        return Jwt.issuer("http://localhost:8080")
            .upn("rodrigo@ifrs.dev")
            .groups(new HashSet<>(Arrays.asList("User", "Admin")))
            .claim(Claims.full_name, "Rodrigo Prestes Machado")
            .sign();
    }

}
