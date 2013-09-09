package se.umejug.rest.jaxrs;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class WebTestBase {
	private static final int SERVER_PICKS_PORT = 0;
	protected WebDriver browser;
	protected String baseUrl;
	protected WebAppContext webAppContext;

	public void setUp() throws Exception {

		Server server = new Server(SERVER_PICKS_PORT);

		webAppContext = new WebAppContext("src/main/webapp", "/");
		server.setHandler(webAppContext);
		server.start();

		int port = server.getConnectors()[0].getLocalPort();
		baseUrl = "http://localhost:" + port + "/";
		browser = createWebDriver();
	}

	/**
	 * Returns fresh webDriver
	 * @return
	 */
	protected HtmlUnitDriver createWebDriver() {
		return new HtmlUnitDriver() {
			@Override
			public WebElement findElement(By by) {
				try {
					return super.findElement(by);
				} catch (NoSuchElementException e) {
					throw new NoSuchElementException("Could not find " + by + " in\n" + getPageSource());
				}
			}
		};
	}
}
