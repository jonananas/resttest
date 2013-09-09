package se.umejug.web;

import static org.fest.assertions.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

import se.umejug.rest.jaxrs.WebTestBase;


public class EhandelServiceWebTest extends WebTestBase {

	@Override
	@Before
	public void setUp() throws Exception {
		super.setUp();
	}

	@Test
	public void callingBeraknaPrisShouldReturnPris() throws Exception {
		String beraknaPrisUrl = "customer";
		assertThat(getPageSource(beraknaPrisUrl)).contains("OK");
	}

	private String getPageSource(String prisInfoUrl) {
		browser.get(baseUrl + prisInfoUrl);
		String pageSource = browser.getPageSource();
		return pageSource;
	}
}
