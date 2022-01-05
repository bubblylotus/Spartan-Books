package com.GrimoireGuide.daoTest;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.Test;

import com.GrimoireGuide.dao.BookDAO;
import com.GrimoireGuide.entity.Book;
import com.GrimoireGuide.entity.Source;


class BookDAOTest {

	private static EntityManagerFactory emf;
	private static EntityManager em;
	private static  BookDAO bookDAO;
	@Test
	void testCreatebook() {
		Book book1 = new Book();
		book1.setTitle("The Lord of the Rings");
		book1.setAuthor("J. R. R. Tolkien");
		book1.setDescription("he Lord of the Rings is an epic high-fantasy novel by English author "
				+ "and scholar J. R. R. Tolkien. Set in Middle-earth, intended to be Earth at some "
				+ "distant time in the past, the story began as a sequel to Tolkien's 1937 children's "
				+ "book The Hobbit.");
		
		
		emf = Persistence.createEntityManagerFactory("GrimoireGuide");
		em = emf.createEntityManager();
		bookDAO = new BookDAO(em);

		//don't need to begin, persist, commit manually every time, just use dao
		bookDAO.create(book1);
		
		em.close();
		emf.close();
		
		assertTrue(book1.getBookId() > 0); //if id >0 that means it was successful created
		
		
	}
	@Test
	void testUpdatebook() throws IOException {
		emf = Persistence.createEntityManagerFactory("GrimoireGuide");
		em = emf.createEntityManager();
		bookDAO = new BookDAO(em);
		
		Book book1 = new Book();
		book1 = bookDAO.get(3);
		
		book1.setImg_link("https://images-na.ssl-images-amazon.com/images/I/415UY+ToE-L._SY344_BO1,204,203,200_.jpg");
		
		


		bookDAO.update(book1);
		
		String expected = book1.getImg_link();
		String actual = bookDAO.get(3).getImg_link();		
		em.close();
		emf.close();
		
		assertEquals(expected, actual); 
		
		
	}
	@Test
	public void testGetBook() {
		Integer bookId = 9;
		
		emf = Persistence.createEntityManagerFactory("GrimoireGuide");
		em = emf.createEntityManager();
		bookDAO = new BookDAO(em);
		
		Book book1 = bookDAO.get(bookId);
		
		em.close();
		emf.close();
		
		System.out.println(book1.getTitle());
		List<Source> sources = book1.getSources();
		//Source source = new Source();
		for(Source source:sources) {
			System.out.println(source.getName());
		}
		//test is successful when assertion is true
		assertNotNull(book1);
	}
	@Test
	public void testListAll() {
		emf = Persistence.createEntityManagerFactory("GrimoireGuide");
		em = emf.createEntityManager();
		bookDAO = new BookDAO(em);
		
		List<Book> bookList = bookDAO.listAll();
		
		em.close();
		emf.close();
		
		System.out.println(bookList.size());
		assertTrue(bookList.size() > 0);
	}
	@Test
	public void testCount() {
		emf = Persistence.createEntityManagerFactory("GrimoireGuide");
		em = emf.createEntityManager();
		bookDAO = new BookDAO(em);
		
		long bookCount = bookDAO.count();
		
		em.close();
		emf.close();
		
		assertEquals(5, bookCount);
	}
	@Test
	public void testFindByTitle() {
		emf = Persistence.createEntityManagerFactory("GrimoireGuide");
		em = emf.createEntityManager();
		bookDAO = new BookDAO(em);
		
		String title = "Effective Java";
		Book book1 = bookDAO.findByTitle(title).get(0);
		
		em.close();
		emf.close();
		
		System.out.println(book1.getAuthor());
		assertTrue(book1.getBookId() > 0);
	}
	@Test
	public void testFindByCourse() {
		emf = Persistence.createEntityManagerFactory("GrimoireGuide");
		em = emf.createEntityManager();
		bookDAO = new BookDAO(em);
		
		String courseNumber = "csc454";
		Book book1 = bookDAO.findByCourse(courseNumber).get(0);
		
		em.close();
		emf.close();
		
		System.out.println(book1.getTitle());
		assertTrue(book1.getBookId() > 0);
	}
	@Test
	public void testSearch() {
		emf = Persistence.createEntityManagerFactory("GrimoireGuide");
		em = emf.createEntityManager();
		bookDAO = new BookDAO(em);
		
		String keyword = "author";
		List<Book> result = bookDAO.search(keyword);
		
		em.close();
		emf.close();
		
		for(Book book1: result) {
			System.out.println(book1.getTitle());
		}
		assertTrue(result.size() > 0);
	}
	//update all for images
	@Test
	public void setAllImages() throws IOException {
		emf = Persistence.createEntityManagerFactory("GrimoireGuide");
		em = emf.createEntityManager();
		bookDAO = new BookDAO(em);
		
		String imagePath = "C:\\Users\\GFRD\\Documents\\340 project\\book images\\introduction to algorithms.JPG";
		byte[] imageBytes = Files.readAllBytes(Paths.get(imagePath));
		
		List<Book> bookList = bookDAO.listAll();
		for(Book book:bookList) {
			book.setImage(imageBytes);
			bookDAO.update(book);
		}
		
		em.close();
		emf.close();
	}
	

}