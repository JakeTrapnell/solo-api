package com.qa.business.service;

public interface UserService {
	
	String createUser(String user);
	String getUser(Long id);
	String getAllUsers();
	String deleteUser(Long id, String password);
	String updateUser(Long id, String password, String user);
}
