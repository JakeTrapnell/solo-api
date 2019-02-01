package com.qa.rest;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import org.apache.log4j.Logger;
import com.qa.business.service.UserService;
import com.qa.persistence.repository.UsersDBR;


@Path("/user")
public class UserEndPoint {
	
	@Inject
	private UserService service;
	
	@Path("/json/{id}")
	@GET
	@Produces({"application/json"})
	public String getUser(@PathParam("id") Long id) {
		return service.getUser(id);
		//http://localhost:8080/Solo-API/rest/user/json/(id number)
	}
	
	@Path("/json")
	@GET
	@Produces({"application/json"})
	public String getAllUsers() {
		return service.getAllUsers();
	}
	
	@Path("/json")	
	@POST
	@Produces({"application/json"})
	public String createUser(String user) {
		return service.createUser(user);
		//http://localhost:8080/Solo-API/rest/user/json
	}
	
	@Path("/json/{id}")
	@DELETE
	@Produces({"application/json"})
	public String deleteUser(@PathParam("id") Long id) {
		return service.deleteUser(id);
		//localhost:8080/Solo-API/rest/user/json/1 deletes user 1
	}
	
	@Path("/json/{id}")
	@POST
	@Produces({"application/json"})
	public String updateUser(@PathParam("id") Long id, String user) {
		return service.updateUser(id, user);
		// localhost:8080/Solo-API/rest/user/json/3 replaces user 3 with what ever is sent
	}
	
	public void setService(UserService service) {
		this.service = service;
	}

}
