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
import com.qa.business.service.RecipeService;

@Path("/recipe")
public class RecipeEndPoint {

	@Inject
	private RecipeService service;
	
	@Path("json")
	@GET
	@Produces({"application/json"})
	public String getRecipes() {
		return service.getAllRecipes();
		//url: GET
		//http://localhost:8080/Solo-API/rest/recipe/json
	}
	
	@Path("json")
	@POST
	@Produces({"application/json"})
	public String addRecipe(String recipe) {
		return service.createRecipe(recipe);
		//url: POST			
		//http://localhost:8080/Solo-API/rest/recipe/json
	}
	
	@Path("/json/{id}")
	@DELETE
	@Produces({"application/json"})
	public String deleteRecipe(@PathParam("id") Long id) {
		return service.deleteRecipe(id);
		//localhost:8080/Solo-API/rest/recipe/json/1 --deletes user 1
	}
	
	@Path("/json/{id}")
	@POST
	@Produces({"application/json"})
	public String updateRecipe(@PathParam("id") Long id, String recipe) {
		return service.updateRecipe(id, recipe);
		// localhost:8080/Solo-API/rest/recipe/json/3 replaces recipe 3 with what ever is sent
	}
	
	public void setService(RecipeService service) {
		this.service = service;
	}
	
}
