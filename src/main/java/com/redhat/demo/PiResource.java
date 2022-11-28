package com.redhat.demo;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/pi")
@Produces(MediaType.APPLICATION_JSON)
public class PiResource {

    @Inject
    PiService piService;

    @GET
    @Path("/{n}")
    public PiResponse getPi(@PathParam("n") int n) {
        if (n <= 0) throw new RuntimeException("Complexity can't be negative");
        if (n > 8) throw new RuntimeException("Complexity over 8 is not allowed");
        var complexity = Math.pow(10, n);
        return new PiResponse(complexity, piService.calculatePi(complexity));
    }

    public record PiResponse(double n, double pi) {
    }

}
