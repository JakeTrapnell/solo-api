package com.qa.persistence.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Entity
public class RecipesTable {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long id;
	
	@Size(min = 2, max = 50)
	private String cuisine;
	
	private String timeToCook;
	private String isVegitarian;
	private String course;
	private String ingredients;
	private String method;
	
	public RecipesTable(String cuisine, String timeToCook, String isVegitarian, 
						String course, String ingredients, String method) {
		
		this.cuisine = cuisine;
		this.timeToCook = timeToCook;
		this.isVegitarian = isVegitarian;
		this.course = course;
		this.ingredients = ingredients;
		this.method = method;	
	}
	
	public RecipesTable() {
		
	}

	public String getCuisine() {
		return cuisine;
	}

	public void setCuisine(String cuisine) {
		this.cuisine = cuisine;
	}

	public String getTimeToCook() {
		return timeToCook;
	}

	public void setTimeToCook(String timeToCook) {
		this.timeToCook = timeToCook;
	}

	public String getIsVegitarian() {
		return isVegitarian;
	}

	public void setIsVegitarian(String isVegitarian) {
		this.isVegitarian = isVegitarian;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getIngredients() {
		return ingredients;
	}

	public void setIngredients(String ingredients) {
		this.ingredients = ingredients;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
}
