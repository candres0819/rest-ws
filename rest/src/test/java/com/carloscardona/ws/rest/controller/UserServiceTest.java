package com.carloscardona.ws.rest.controller;

import static org.junit.Assert.*;

import org.junit.Test;

import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.test.framework.JerseyTest;

public class UserServiceTest extends JerseyTest {

	public static final String PATH_ALL = "user/all";
	public static final String PATH_NAME = "user/name/";
	public static final String PATH_AGE = "user/age/";
	WebResource webResource;

	public UserServiceTest() throws Exception {
		super("com.carloscardona.ws.rest.controller");
		this.webResource = resource();
	}

	@Test
	public void testAll() {
		String responseMsg = webResource.path(PATH_ALL).get(String.class);
		assertEquals("Hello World", responseMsg);
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
}
