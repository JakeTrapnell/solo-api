package com.qa.persistence.repository;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import java.util.Collection;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import com.qa.persistence.domain.RecipesTable;
import com.qa.persistence.domain.UsersTable;
import com.qa.util.JSONUtil;

@Transactional(SUPPORTS)
@Default
public class RecipesDBR implements RecipesRepository {

	@PersistenceContext(unitName="primary")
	private EntityManager manager;
	
	@Inject
	private JSONUtil util;
	
	@Transactional(REQUIRED)
	public String createRecipe(String recipe) {
		RecipesTable aRecipe = util.getObjectForJSON(recipe, RecipesTable.class);
		manager.persist(aRecipe);
		return "{\\\"message\\\": \\\"Recipe has been sucessfully added\\\"}";
	}

	@Transactional(REQUIRED)
	public String getRecipe(Long id) {	
		//Query query = manager.createQuery("Select a FROM RecipesTable a");
		//Collection<RecipesTable> recipes = (Collection<RecipesTable>) query.getResultList();
		//return util.getJSONForObject(recipes);
		RecipesTable recipeInDB = findRecipe(id);
		if(recipeInDB != null) {
			return util.getJSONForObject(recipeInDB);
		}
		else {
			return "{\"message\": \"recipe not found\"}";
		}
	}

	@Transactional(REQUIRED)
	public String deleteRecipe(Long id) {
		RecipesTable recipeInDB = findRecipe(id);
		if(recipeInDB != null) {
			manager.remove(recipeInDB);
		}
		return "{\"message\": \"Recipe sucessfully deleted\"}";
	}

	@Transactional(REQUIRED)
	public String updateRecipe(Long id, String recipe) {
		RecipesTable theRecipe = findRecipe(id);
		manager.remove(theRecipe);
		RecipesTable aRecipe = util.getObjectForJSON(recipe, RecipesTable.class);
		manager.persist(aRecipe);
		return  "{\"message\": \"Recipe sucessfully updated\"}";
	}
	
	private RecipesTable findRecipe(Long id) {
		return manager.find(RecipesTable.class, id);
	}

}
