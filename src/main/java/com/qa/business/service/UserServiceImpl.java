package com.qa.business.service;

import javax.inject.Inject;
import org.apache.log4j.Logger;
import com.qa.persistence.domain.UsersTable;
import com.qa.persistence.repository.UsersRepository;
import com.qa.util.JSONUtil;
import javassist.bytecode.analysis.Util;

public class UserServiceImpl  implements UserService{
	
	@Inject
	private UsersRepository repo;

	public String createUser(String user) {
		
		if(user.length() == 0) {
			String message = "cannot create user with empty field";
			return message;
		}
		else {
			return repo.createUser(user);
		}
	}

	public String getUser(Long id) {
		return repo.getUser(id);
	}
	
	public String getAllUsers() {
		return repo.getAllUsers();
	}

	public String deleteUser(Long id) {
		return repo.deleteUser(id);
	}

	public String updateUser(Long id, String user) {
		
		if(user.length() == 0) {
			String message = "cannot update user with empty field";
			return message;
		}
		else {
			return repo.updateUser(id, user);
		}
	}

	public void setRepo(UsersRepository repo) {
		this.repo = repo;
	}
}
