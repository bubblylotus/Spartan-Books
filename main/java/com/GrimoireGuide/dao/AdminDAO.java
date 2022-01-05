package com.GrimoireGuide.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;

import com.GrimoireGuide.entity.Admin;

public class AdminDAO extends JpaDAO<Admin> implements GenericDAO<Admin> {
	public AdminDAO(EntityManager em) {
		super(em);
	}
	public Admin create(Admin Admin) {
		return super.create(Admin);
	}
	@Override
	public Admin update(Admin Admin) {
		return super.update(Admin);
	}

	@Override
	public Admin get(Object adminId) {
		return super.find(Admin.class, adminId);
	}

	@Override
	public void delete(Object adminId) {
		super.delete(Admin.class, adminId);
	}
	public Admin findByEmail(String email) {
		List<Admin> admins = super.findWithNamedQuery("Admin.findByEmail", "email", email);
		if(admins != null && admins.size() > 0) {
			return admins.get(0);
		}
		return null;
	}

	@Override
	public List<Admin> listAll() {
		return super.findWithNamedQuery("Admin.findAll");
	}

	@Override
	public long count() {
		return super.countWithNamedQuery("Admin.countAll");
	}
	public Admin checkLogin(String email, String password) {
		Map<String, Object> params = new HashMap<>();
		params.put("email", email);
		params.put("password", password);
		
		List<Admin> admins = super.findWithNamedQuery("Admin.checkLogin", params);
		if(admins != null && admins.size() > 0) {
			return admins.get(0);
		}

		return null;
	}
}
