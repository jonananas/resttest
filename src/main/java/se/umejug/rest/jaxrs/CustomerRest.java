package se.umejug.rest.jaxrs;

import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import se.umejug.rest.jaxrs.RestError.ErrorCodes;

@Stateless
@Path("/customer")
public class CustomerRest {
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public Response getCustomer() {
		return Response.ok("OK").build();
	}
	
	@PUT
	@Produces(MediaType.TEXT_PLAIN)
	public Response putCustomer() {
		return Response.status(Status.INTERNAL_SERVER_ERROR).entity(new RestError("Internal server error", ErrorCodes.INTERNAL_SERVER_ERROR)).build();
	}
}
