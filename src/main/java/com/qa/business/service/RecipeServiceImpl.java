package com.qa.business.service;

import javax.inject.Inject;
import org.apache.log4j.Logger;
import com.qa.persistence.domain.RecipesTable;
import com.qa.persistence.repository.RecipesRepository;
import com.qa.util.JSONUtil;
import javassist.bytecode.analysis.Util;

public class RecipeServiceImpl implements RecipeService {

	@Inject
	private RecipesRepository repo;
	
	public String createRecipe(String recipe) {
		return repo.createRecipe(recipe);
	}

	public String getRecipe(Long id) {
		return repo.getRecipe(id);
	}
	
	public String getAllRecipes() {
		return repo.getAllRecipes();
	}

	public String deleteRecipe(Long id) {
		return repo.deleteRecipe(id);
	}

	public String updateRecipe(Long id, String recipe) {
		return repo.deleteRecipe(id);
	}
	
	public void setRepo(RecipesRepository repo) {
		this.repo = repo;
	}

}
