package se.umejug.web;

import static org.fest.assertions.Assertions.assertThat;

import org.json.JSONObject;
import org.junit.Test;

public class SimpleJSONTest {

	@Test
	public void testEncodeJSONOBject() throws Exception {
		JSONObject obj = new JSONObject();
		obj.put("totalPris", new Double(1000.21));
		assertThat(obj.toString()).isEqualTo("{\"totalPris\":1000.21}");
	}

	@Test
	public void testJSONError() throws Exception {
		JSONObject obj = new JSONObject();
		obj.put("LoginError", "Wrong username or password");
		assertThat(obj.toString()).isEqualTo("{\"LoginError\":\"Wrong username or password\"}");
	}
}
