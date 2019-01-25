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
		return "{\\\"message\\\": \\\"User has been sucessfully added\\\"}";
	}

	@Transactional(REQUIRED)
	public String getAllUsers() {
		Query query = manager.createQuery("Select a FROM UsersTable a");
		Collection<UsersTable> users = (Collection<UsersTable>) query.getResultList();
		return util.getJSONForObject(users);
	}

	@Transactional(REQUIRED)
	public String deleteUser(Long id) {
		UsersTable userInDB = findUser(id);
		if(userInDB != null) {
			manager.remove(userInDB);
		}
		return "{\"message\": \"User sucessfully deleted\"}";
	}

	@Transactional(REQUIRED)
	public String updateUser(Long id, String user) {
		UsersTable theUser = findUser(id);
		manager.remove(theUser);
		UsersTable aUser = util.getObjectForJSON(user, UsersTable.class);
		manager.persist(aUser);
		return  "{\"message\": \"User sucessfully updated\"}";
	}
	
	private UsersTable findUser(Long id) {
		return manager.find(UsersTable.class, id);
	}

}
