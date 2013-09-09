package se.umejug.web;

import static org.fest.assertions.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Before;
import org.junit.Test;

import se.umejug.web.CustomerRestServlet;

public class CustomerServletTest {
	
	
	private HttpServletRequest req;
	private HttpServletResponse resp;
	private StringWriter pageSource;

	@Before
	public void setUp() throws IOException {
		req = mock(HttpServletRequest.class);
		resp = mock(HttpServletResponse.class);

		when(req.getMethod()).thenReturn("GET");
		pageSource = new StringWriter();
		when(resp.getWriter()).thenReturn(new PrintWriter(pageSource));

	}

	@Test
	public void shouldReturnCustomer() throws Exception {

		CustomerRestServlet customerServlet = new CustomerRestServlet();
		
		customerServlet.service(req, resp);

		assertThat(pageSource.toString()).isEqualTo("OK");
		verify(resp).setContentType("text/plain");
	}
}
