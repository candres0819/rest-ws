package com.carloscardona.ws.rest.controller;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.carloscardona.ws.rest.dao.UserDAO;
import com.carloscardona.ws.rest.dao.UserDAOImpl;
import com.carloscardona.ws.rest.model.User;

/**
 * 
 * @author candr
 *
 */
@Path("user")
@Produces(MediaType.APPLICATION_XML)
public class UserService {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);

	private UserDAO userDao;

	public UserService() {
		super();
		this.userDao = new UserDAOImpl();
		LOGGER.info("info service constructor");
	}

	@GET
	@Path("/all")
	public List<User> users() {
		return this.userDao.allUsers();
	}

	@GET
	@Path("/name/{i}")
	public String userName(@PathParam("i") String i) {
		String name = i;
		return name;
	}

	@GET
	@Path("/age/{j}")
	public String userAge(@PathParam("j") int j) {
		int age = j;
		return String.valueOf(age);
	}
}