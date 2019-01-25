package com.qa.persistence.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Entity
public class UsersTable {
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private Long id;
	
	@Size(min = 2, max = 20)
	private String name;
	
	public UsersTable(String name) {
		this.name = name;
	}
	
	public UsersTable() {
		
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

}
