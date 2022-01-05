package com.GrimoireGuide.daoTest;

import static org.junit.jupiter.api.Assertions.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.Test;

import com.GrimoireGuide.dao.BookDAO;
import com.GrimoireGuide.dao.SourceDAO;
import com.GrimoireGuide.dao.SourceDAO;
import com.GrimoireGuide.entity.Book;
import com.GrimoireGuide.entity.Source;

class SourceDAOTest {
	private static EntityManagerFactory emf;
	private static EntityManager em;
	private static  SourceDAO sourceDAO;
	private static BookDAO bookDAO;

	@Test
	void testCreatesource() {
		emf = Persistence.createEntityManagerFactory("GrimoireGuide");
		em = emf.createEntityManager();
		sourceDAO = new SourceDAO(em);
		bookDAO = new BookDAO(em);
		Book book1 = new Book();
		book1 = bookDAO.findByTitle("Introduction to Algorithms").get(0);
		Book book2 = bookDAO.get(12);
		
		Source source1 = new Source();
		source1.setName("Ebay");
		source1.setLink("https://www.ebay.com/itm/324907729126?epid=7038810001&hash=item4ba60280e6:g:JXsAAOSwzgBhoWsP");
		source1.setPrice(12.36);
		source1.setRent(false);
		source1.setBook(book2);
		
		
		
		
		

		//don't need to begin, persist, commit manually every time, just use dao
		sourceDAO.create(source1);
		
		em.close();
		emf.close();
		
		assertTrue(source1.getSourceId() > 0); //if id >0 that means it was successful created		
	}
	@Test
	void testDeleteSource() {
		emf = Persistence.createEntityManagerFactory("GrimoireGuide");
		em = emf.createEntityManager();
		sourceDAO = new SourceDAO(em);
		
		Source source1 = sourceDAO.get(4);
		
		
		
		
		

		//don't need to begin, persist, commit manually every time, just use dao
		sourceDAO.delete(source1);
		
		em.close();
		emf.close();
		
		assertNull(sourceDAO.get(4)); //if id >0 that means it was successful created		
	}
	

}
