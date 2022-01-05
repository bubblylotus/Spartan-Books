package com.GrimoireGuide.daoTest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.Test;

import com.GrimoireGuide.dao.UserDAO;
import com.GrimoireGuide.dao.UserDAO;
import com.GrimoireGuide.dao.UserDAO;
import com.GrimoireGuide.entity.User;
import com.GrimoireGuide.entity.User;


class UserDAOTest {
	private static EntityManagerFactory emf;
	private static EntityManager em;
	private static  UserDAO userDAO;
	@Test
	void testCreateUser() {
		User user = new User();
		user.setEmail("kidestm@gm.com");
		user.setName("Kidest M");
		user.setPassword("password");
		emf = Persistence.createEntityManagerFactory("GrimoireGuide");
		em = emf.createEntityManager();
		userDAO = new UserDAO(em);

		//don't need to begin, persist, commit manually every time, just use dao
		userDAO.create(user);
		
		em.close();
		emf.close();
		
		assertTrue(user.getUserId()> 0);
	}
	
	@Test
	void testFindByEmail() {
		emf = Persistence.createEntityManagerFactory("GrimoireGuide");
		em = emf.createEntityManager();
		userDAO = new UserDAO(em);
		
		User user = userDAO.findByEmail("kidestm@gm.com");
		
		assertNotNull(user);
		
	}
	@Test
	void testCheckLogin() {
		emf = Persistence.createEntityManagerFactory("GrimoireGuide");
		em = emf.createEntityManager();
		userDAO = new UserDAO(em);
		String email = "kidestm@gm.com";
		String password = "password";
		User user = userDAO.checkLogin(email, password);
		
		System.out.println(user.getName());
		
		assertNotNull(user);
		
	}
	@Test
	public void testListAll() {
		emf = Persistence.createEntityManagerFactory("GrimoireGuide");
		em = emf.createEntityManager();
		userDAO = new UserDAO(em);
		
		List<User> userList = userDAO.listAll();
		
		em.close();
		emf.close();
		
		System.out.println(userList.size());
		assertTrue(userList.size() > 0);
	}

}
