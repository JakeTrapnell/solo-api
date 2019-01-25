package com.qa.persistence.repository;

public interface UsersRepository {
	
	String createUser(String user);
	String getAllUsers();
	String deleteUser(Long id);
	String updateUser(Long id, String user);

}
