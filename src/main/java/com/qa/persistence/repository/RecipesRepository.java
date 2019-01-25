package com.qa.persistence.repository;

public interface RecipesRepository {

	String createRecipe(String recipe);
	String getRecipes();
	String deleteRecipe(Long id);
	String updateRecipe(Long id, String recipe);
}
