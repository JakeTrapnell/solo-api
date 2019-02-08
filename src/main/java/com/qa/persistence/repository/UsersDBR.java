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

import com.qa.persistence.domain.UsersTable;
import com.qa.util.JSONUtil;


@Transactional(SUPPORTS)
@Default
public class UsersDBR implements UsersRepository {
	
	@PersistenceContext(unitName="primary")
	private EntityManager manager;
	
	@Inject
	private JSONUtil util;
	
	
	@Transactional(REQUIRED)
	public String createUser(String user) {
		UsersTable aUser = util.getObjectForJSON(user, UsersTable.class);
		manager.persist(aUser);
		return "User has been sucessfully added";
	}

	@Transactional(REQUIRED)
	public String getUser(Long id) {
		//Query query = manager.createQuery("Select a FROM UsersTable a");
		//Collection<UsersTable> users = (Collection<UsersTable>) query.getResultList();
		//return util.getJSONForObject(users);
		UsersTable userInDB = findUser(id);
		if(userInDB != null) {
			return util.getJSONForObject(userInDB);
		}
		else {
			return "User not found";
		}
	}
	
	@Transactional(REQUIRED)
	public String getAllUsers() {
		Query query = manager.createQuery("Select a FROM UsersTable a");
				Collection<UsersTable> users = (Collection<UsersTable>) query.getResultList();
				return util.getJSONForObject(users);
	}

	@Transactional(REQUIRED)
	public String deleteUser(Long id, String password) {
		UsersTable userInDB = findUser(id);
		String userPass = userInDB.getPassword();
		if(userInDB != null && userPass.equals(password)) {
			manager.remove(userInDB);
			return "User sucessfully deleted";
		}
		else {
			return"User has not been deleted";
		}
	
	}

	@Transactional(REQUIRED)
	public String updateUser(Long id, String password, String user) {
		UsersTable theUser = findUser(id);
		String userPass = theUser.getPassword();
		if(theUser != null && userPass.equals(password)) {
			manager.remove(theUser);
			UsersTable aUser = util.getObjectForJSON(user, UsersTable.class);
			manager.persist(aUser);
			return  "User sucessfully updated";
		}
		else {
			return "failed to update user";
		}
	}
	
	private UsersTable findUser(Long id) {
		return manager.find(UsersTable.class, id);
	}
	
	public void setManager(EntityManager manager) {
		this.manager = manager;
	}

	public void setUtil(JSONUtil util) {
		this.util = util;
	}

}
