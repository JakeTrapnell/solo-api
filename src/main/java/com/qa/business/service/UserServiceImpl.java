package com.qa.business.service;

import java.util.regex.Pattern;

import javax.inject.Inject;
import org.apache.log4j.Logger;
import com.qa.persistence.domain.UsersTable;
import com.qa.persistence.repository.UsersRepository;
import com.qa.util.JSONUtil;
import javassist.bytecode.analysis.Util;

public class UserServiceImpl  implements UserService{
	
	@Inject
	private UsersRepository repo;
	@Inject
	private JSONUtil util;
	
	public String CreationChecklist() {
		return null;
	}
	
	public String createUser(String user) {
		UsersTable tempUser = util.getObjectForJSON(user, UsersTable.class);
		String upperPattern = ".*[A-Z].*";
		String lowerPattern = ".*[a-z].*";
		String numPattern = ".*[0-9].*";
		String message;
		String userPass = tempUser.getPassword().toString();
		String userName = tempUser.getName().toString();
		String userMail = tempUser.getEmail().toString();
		if(userName.isEmpty())  {
			message = "name has not been entered!";
			return message;
		}
		
		if(userPass.isEmpty() || !userPass.matches(upperPattern) ||  !userPass.matches(lowerPattern) || !userPass.matches(numPattern)) {
			message = "invalid password! must contain one capitol letter, one number and be at least 5 characters long";
			return message;
		}
		if(userMail.isEmpty() || !userMail.contains("@") || !userMail.contains(".com") || !userMail.contains(".co.uk")) {
			message = "invalid email adress!";
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

	public String deleteUser(Long id, String password) {
		return repo.deleteUser(id, password);
	}

	public String updateUser(Long id, String password, String user) {
		
		if(user.length() == 0) {
			String message = "cannot update user with empty field";
			return message;
		}
		else {
			return repo.updateUser(id, password, user);
		}
	}

	public void setRepo(UsersRepository repo) {
		this.repo = repo;
	}
}
