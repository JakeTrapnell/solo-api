package com.qa.persistence.repository;

public interface RecipesRepository {

	String createRecipe(String recipe);
	String getRecipe(Long id);
	String deleteRecipe(Long id);
	String updateRecipe(Long id, String recipe);
}
