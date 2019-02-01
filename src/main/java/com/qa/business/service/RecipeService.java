package com.qa.business.service;

public interface RecipeService {
	
	String createRecipe(String recipe);
	String getRecipe(Long id);
	String getAllRecipes();
	String deleteRecipe(Long id);
	String updateRecipe(Long id, String recipe);

}
