package com.GrimoireGuide.daoTest;

import static org.junit.jupiter.api.Assertions.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.Test;

import com.GrimoireGuide.dao.CourseDAO;
import com.GrimoireGuide.entity.Course;

class CourseDAOTest {
	private static EntityManagerFactory emf;
	private static EntityManager em;
	private static  CourseDAO courseDAO;

	@Test
	void testCreatebook() {
		Course course1 = new Course();
		course1.setCourseNumber("CST105");
		course1.setTitle("communication");
		
		
		
		
		emf = Persistence.createEntityManagerFactory("GrimoireGuide");
		em = emf.createEntityManager();
		courseDAO = new CourseDAO(em);

		//don't need to begin, persist, commit manually every time, just use dao
		courseDAO.create(course1);
		
		em.close();
		emf.close();
		
		assertTrue(course1.getCourseId() > 0); //if id >0 that means it was successful created
		
		
	}

}
