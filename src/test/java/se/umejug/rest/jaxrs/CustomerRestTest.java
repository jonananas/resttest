package se.umejug.rest.jaxrs;

import static org.fest.assertions.Assertions.assertThat;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.junit.Before;
import org.junit.Test;

import se.umejug.rest.jaxrs.RestError.ErrorCodes;

public class CustomerRestTest {
	
	private CustomerRest customerRest;
	
	@Before
	public void setup() {
		customerRest = new CustomerRest();
	}

	@Test
	public void shouldReturnOK() throws Exception {
		
		Response response = customerRest.getCustomer();
		
		assertResponseCode(response, Response.Status.OK);
		assertThat(response.getEntity()).isEqualTo("OK");
	}
	
	@Test
	public void shouldReturnServerError() throws Exception {
		Response response = customerRest.putCustomer();
		assertResponseCode(response, Response.Status.INTERNAL_SERVER_ERROR);
		assertRestError(response, "Internal server error", ErrorCodes.INTERNAL_SERVER_ERROR);
	}
	
	private void assertRestError(Response response, String message, ErrorCodes code) {
		assertThat(response.getEntity()).isEqualTo(new RestError(message, code));
	}

	private void assertResponseCode(Response response, Status status) {
		assertThat(response.getStatus()).isEqualTo(status.getStatusCode());
	}


}
