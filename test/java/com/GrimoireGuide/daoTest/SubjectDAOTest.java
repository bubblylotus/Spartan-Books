package com.GrimoireGuide.daoTest;

import static org.junit.jupiter.api.Assertions.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.Test;

import com.GrimoireGuide.dao.SubjectDAO;
import com.GrimoireGuide.entity.Subject;

class SubjectDAOTest {

	private static EntityManagerFactory emf;
	private static EntityManager em;
	private static  SubjectDAO subjectDAO;

	@Test
	void testCreateSubject() {
		Subject subject1 = new Subject();
		subject1.setName("Human Development and Family Studies");
		subject1.setAbbr("HDF");
		
		
		emf = Persistence.createEntityManagerFactory("GrimoireGuide");
		em = emf.createEntityManager();
		subjectDAO = new SubjectDAO(em);

		//don't need to begin, persist, commit manually every time, just use dao
		subjectDAO.create(subject1);
		
		em.close();
		emf.close();
		
		assertTrue(subject1.getSubjectId() > 0); //if id >0 that means it was successful created
		
		
	}

}
