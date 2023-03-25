package com.example.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/hello")
public class HelloWorldResource {
    /*@GET
    @Produces(MediaType.TEXT_PLAIN)
    public String sayHello() {
        return "Hello, World!";
    }*/

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    //@Path("hello-world/{name}")

    public String sayHello(@QueryParam("name") String name) {
        if (name == null || name.trim().isEmpty()) {
            return "Hello, World!";
        } else {
            return "Hello, " + name + "!";
        }
    }


}
