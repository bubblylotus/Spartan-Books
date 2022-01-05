package com.GrimoireGuide.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;

import com.GrimoireGuide.entity.User;
import com.GrimoireGuide.entity.User;

public class UserDAO extends JpaDAO<User> implements GenericDAO<User> {
	public UserDAO(EntityManager em) {
		super(em);
	}
	public User create(User User) {
		return super.create(User);
	}
	@Override
	public User update(User User) {
		return super.update(User);
	}

	@Override
	public User get(Object userId) {
		return super.find(User.class, userId);
	}

	@Override
	public void delete(Object userId) {
		super.delete(User.class, userId);
	}
	public User findByEmail(String email) {
		List<User> users = super.findWithNamedQuery("User.findByEmail", "email", email);
		if(users != null && users.size() > 0) {
			return users.get(0);
		}
		return null;
	}

	@Override
	public List<User> listAll() {
		return super.findWithNamedQuery("User.findAll");
	}

	@Override
	public long count() {
		return super.countWithNamedQuery("User.countAll");
	}
	public User checkLogin(String email, String password) {
		Map<String, Object> params = new HashMap<>();
		params.put("email", email);
		params.put("password", password);
		
		List<User> users = super.findWithNamedQuery("User.checkLogin", params);
		if(users != null && users.size() > 0) {
			return users.get(0);
		}

		return null;
	}
}
