package se.umejug.web;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;



public class WebServer {

	public static void main(String[] args) throws Exception {

		Server server = new Server(8090);
		server.setHandler(new WebAppContext("src/main/webapp", "/"));
		server.start();

		System.out.println("http://localhost:8090/");
	}
}
