package se.umejug.rest.jaxrs;

import static org.fest.assertions.Assertions.assertThat;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class CustomerWebTest extends WebTestBase {
	
	@Override
	@Before
	public void setUp() throws Exception {
		super.setUp();
	}

	@Test
	public void customerShouldReturnCustomer() throws Exception {
		String url = "customer";
		browser.get(baseUrl + url);
		String pageSource = browser.getPageSource();
		assertThat(pageSource).contains("OK");
	}
}
