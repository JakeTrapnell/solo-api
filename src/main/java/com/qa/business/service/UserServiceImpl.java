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
	
	public String creationChecklist(String user) {
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
		if(userPass.length() < 5 || !userPass.matches(upperPattern) || !userPass.matches(numPattern)) {
			message = "invalid password! must contain one capitol letter, one number and be at least 5 characters long";
			return message;
		}
		if(userMail.isEmpty() || !userMail.contains("@") && (!userMail.contains(".com") || !userMail.contains(".co.uk"))) {
			message = "invalid email adress!";
			return message;
		}
		else {
			return null;
		}
	}
	
	public String createUser(String user) {
		if (creationChecklist(user) == null) {
			return repo.createUser(user);
		}
		else {
			return creationChecklist(user);
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
		if (creationChecklist(user) == null) {
			return repo.updateUser(id, password, user);
		}
		else {
			return creationChecklist(user);
		}
	}

	public void setRepo(UsersRepository repo) {
		this.repo = repo;
	}
}
