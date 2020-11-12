package me.potato.getting.started;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Path("/hello")
public class GreetingResource {

  private final GreetingService service;

  @GET
  @Produces(MediaType.TEXT_PLAIN)
  public String hello() {
    return "hello";
  }


  @GET
  @Produces(MediaType.TEXT_PLAIN)
  @Path(value = "/greeting/{name}")
  public String greeting(@PathParam("name") String name) {
    return service.greeting(name);
  }

}

