package com.carloscardona.ws.rest.controller;

import static org.junit.Assert.assertEquals;

import javax.ws.rs.core.MediaType;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import com.carloscardona.ws.rest.model.User;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.test.framework.JerseyTest;

public class UserServiceTest extends JerseyTest {

	private static final String PATH_ALL = "user/all";
	private static final String PATH_NAME = "user/name/";
	private static final String PATH_AGE = "user/age/";
	private static final String PATH_SAVE = "user/save";
	private static final String PATH_UPDATE = "user/update";
	private static final String PATH_DELETE = "user/delete";
	WebResource webResource;

	public UserServiceTest() throws Exception {
		super("com.carloscardona.ws.rest.controller");
		this.webResource = resource();
	}

	@Test
	public void testAll() {
		String response = webResource.path(PATH_ALL).get(String.class);
		JSONObject output = null;
		JSONArray arr = null;
		try {
			output = new JSONObject(response);
			arr = output.getJSONArray("user");
			for (int i = 0; i < arr.length(); i++) {
				JSONObject o = arr.getJSONObject(i);
				System.out.println(o);
			}
		} catch (JSONException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertEquals(JSONArray.class, arr.getClass());
	}

	@Test
	public void testName() {
		String responseMsg = webResource.path(PATH_NAME + "andres").get(String.class);
		assertEquals("andres", responseMsg);
	}

	@Test
	public void testAge() {
		String responseMsg = webResource.path(PATH_AGE + "21").get(String.class);
		assertEquals("21", responseMsg);
	}

	@Test
	public void testSave() {
		User user = new User();
		user.setId(1);
		user.setName("Jane Doe");
		user.setProfession("test");

		ClientResponse response = webResource.path(PATH_SAVE).type(MediaType.APPLICATION_JSON).post(ClientResponse.class, user);

		System.out.println(response);
		Assert.assertEquals(201, response.getStatus());
	}

	@Test
	public void testUpdate() {
		String user = "{\"id\":\"2\",\"name\":\"Carlos\",\"profession\":\"test\"}";
		webResource.path(PATH_UPDATE).type(MediaType.APPLICATION_JSON).put(user);
	}

	@Test
	public void testDelete() {
		webResource.path(PATH_DELETE).delete();
	}
}
