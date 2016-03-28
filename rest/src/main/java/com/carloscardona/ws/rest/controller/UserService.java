package com.carloscardona.ws.rest.controller;

import java.io.IOException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
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
	@Produces(MediaType.APPLICATION_JSON)
	public List<User> users() {
		return this.userDao.all();
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

	@POST
	@Path("/save")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response saveUser(User user) {
		this.userDao.save(user);
		String result = "Track saved : " + user;
		return Response.status(Response.Status.CREATED).entity(result).build();
	}

	@PUT
	@Path("/update")
	@Consumes(MediaType.APPLICATION_JSON)
	public void update(String user) {
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			User userJSON = objectMapper.readValue(user, User.class);
			System.out.println("output: " + userJSON);
			this.userDao.save(userJSON);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@DELETE
	@Path("/delete")
	public void delete(@PathParam("id") int id) {
		// deleting notification
	}
}