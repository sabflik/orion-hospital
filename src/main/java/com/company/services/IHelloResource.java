package com.company.services;

import javax.ws.rs.*;

import org.springframework.http.ResponseEntity;

/**
 * <p>Example resource which returns a simple Hello message</p>
 * @author Chang Kon Han
 * @author John Law
 * @author Wesley Yep
 * @since 23 Feb 2016
 */
@Path("/hello")
public interface IHelloResource {

    /**
     * <p>Returns a hello message</p>
     * @param name
     * @return Hello Message
     */

    @GET
    @Produces("text/plain")
    String hello(@DefaultValue("World!") @QueryParam("name") String name);
    
    
    
    @GET
    @Path("mapPath")
    @Produces("application/json")
    ResponseEntity getMap();

    @GET
    @Path("waitingMapPath")
    @Produces("application/json")
    ResponseEntity getWaitingMap();
    
    @GET
    @Path("stats")
    @Produces("application/json")
    ResponseEntity getStats(@PathParam("month") String month, @PathParam("year") String year);

}
