package com.qa.persistence.repository;

public interface UsersRepository {
	
	String createUser(String user);
	String getUser(Long id);
	String getAllUsers();
	String deleteUser(Long id, String password);
	String updateUser(Long id, String password, String user);

}
