package com.carloscardona.ws.rest.controller;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.carloscardona.ws.rest.dao.UserDao;
import com.carloscardona.ws.rest.model.User;

/**
 * 
 * @author candr
 *
 */
@Path("user")
public class UserService {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);

	UserDao userDao;

	public UserService() {
		super();
		this.userDao = new UserDao();
		LOGGER.info("info service constructor");
	}

	@GET
	@Path("/all")
	@Produces(MediaType.APPLICATION_XML)
	public List<User> users() {
		return this.userDao.getAllUsers();
	}

	@GET
	@Path("/name/{i}")
	@Produces(MediaType.APPLICATION_XML)
	public String userName(@PathParam("i") String i) {
		String name = i;
		return "<User>" + "<Name>" + name + "</Name>" + "</User>";
	}

	@GET
	@Path("/age/{j}")
	@Produces(MediaType.APPLICATION_XML)
	public String userAge(@PathParam("j") int j) {
		int age = j;
		return "<User>" + "<Age>" + age + "</Age>" + "</User>";
	}
}