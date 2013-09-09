package se.umejug.web;

import static javax.servlet.http.HttpServletResponse.SC_INTERNAL_SERVER_ERROR;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

public class CustomerRestServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private final Logger log = Logger.getLogger(CustomerRestServlet.class);

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		try {
			resp.getWriter().append("OK");
			resp.setContentType("text/plain");
		} catch (Exception ex) {
			log.warn(
					"Client "
							+ req.getRemoteAddr()
							+ " failed (internal server error) with exception: \""
							+ ex.getMessage() + "\"", ex);
			resp.sendError(SC_INTERNAL_SERVER_ERROR);
		}
	}
}
