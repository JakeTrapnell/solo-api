package com.qa.persistence.repository;

public interface RecipesRepository {

	String createRecipe(String recipe);
	String getRecipe(Long id);
	String getAllRecipes();
	String deleteRecipe(Long id);
	String updateRecipe(Long id, String recipe);
}
