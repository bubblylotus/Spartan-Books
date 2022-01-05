package com.GrimoireGuide.daoTest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.Test;

import com.GrimoireGuide.dao.AdminDAO;
import com.GrimoireGuide.entity.Admin;

class AdminDAOTest {
	private static EntityManagerFactory emf;
	private static EntityManager em;
	private static AdminDAO adminDAO;

	@Test
	void testCreateAdmin() {
		Admin admin = new Admin();
		admin.setEmail("admin@gm.com");
		admin.setName("Admin");
		admin.setPassword("password");
		emf = Persistence.createEntityManagerFactory("GrimoireGuide");
		em = emf.createEntityManager();
		adminDAO = new AdminDAO(em);

		// don't need to begin, persist, commit manually every time, just use dao
		adminDAO.create(admin);

		em.close();
		emf.close();

		assertTrue(admin.getAdminId() > 0);
	}

	@Test
	void testFindByEmail() {
		emf = Persistence.createEntityManagerFactory("GrimoireGuide");
		em = emf.createEntityManager();
		adminDAO = new AdminDAO(em);

		Admin admin = adminDAO.findByEmail("Admin@gm.com");

		assertNotNull(admin);

	}

	@Test
	void testCheckLogin() {
		emf = Persistence.createEntityManagerFactory("GrimoireGuide");
		em = emf.createEntityManager();
		adminDAO = new AdminDAO(em);
		String email = "admin@test.com";
		String password = "TestpAssword";
		Admin admin = adminDAO.checkLogin(email, password);

		System.out.println(admin.getName());

		assertNotNull(admin);

	}

}
