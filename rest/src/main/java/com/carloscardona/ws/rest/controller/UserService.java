package com.carloscardona.ws.rest.controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.carloscardona.ws.rest.dao.UserDAO;
import com.carloscardona.ws.rest.dao.UserDAOImpl;
import com.carloscardona.ws.rest.model.Track;
import com.carloscardona.ws.rest.model.User;

/**
 * 
 * @author candr
 *
 */
@Path("user")
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
	@Produces(MediaType.APPLICATION_XML)
	public List<User> users() {
		return this.userDao.allUsers();
	}

	@GET
	@Path("/name/{i}")
	@Produces(MediaType.APPLICATION_XML)
	public String userName(@PathParam("i") String i) {
		String name = i;
		return name;
	}

	@GET
	@Path("/age/{j}")
	@Produces(MediaType.APPLICATION_XML)
	public String userAge(@PathParam("j") int j) {
		int age = j;
		return String.valueOf(age);
	}

	@GET
	@Path("/json/track")
	@Produces(MediaType.APPLICATION_JSON)
	public Track track() {
		Track track = new Track();
		track.setTitle("Enter Sandman");
		track.setSinger("Metallica");
		return track;
	}

	@POST
	@Path("/json/savetrack")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response saveTrack(Track track) {
		String result = "Track saved : " + track;
		return Response.status(201).entity(result).build();
	}
}