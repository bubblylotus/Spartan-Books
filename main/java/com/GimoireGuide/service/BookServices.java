package com.GimoireGuide.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.GrimoireGuide.dao.BookDAO;
import com.GrimoireGuide.entity.Book;
import com.GrimoireGuide.entity.Book;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class BookServices {
	private EntityManagerFactory emf;
	private EntityManager em;
	private BookDAO bookDAO;
	private HttpServletRequest req;
	private HttpServletResponse res;
	
	public BookServices(HttpServletRequest req, HttpServletResponse res) {
		super();
		this.req = req;
		this.res = res;
		emf = Persistence.createEntityManagerFactory("GrimoireGuide");
		em = emf.createEntityManager();
		bookDAO = new BookDAO(em);
	}

	public void listBook() throws ServletException, IOException {
		List<Book> listBook = bookDAO.listAll();
		req.setAttribute("bookList", listBook);
		String listPage = "book_list.jsp";
		RequestDispatcher rd = req.getRequestDispatcher(listPage);
		rd.forward(req, res);
	}
	
	public void search() throws ServletException, IOException {
		String keyword = req.getParameter("keyword");
		List<Book> result = null;
		Book resultBook = new Book();
		if(keyword.equals("")) {
			result = bookDAO.listAll();
		}
		else {
			if(bookDAO.findByTitle(keyword) == null) {
				if(bookDAO.findByCourse(keyword) == null) {
					result = bookDAO.search(keyword);
				}
				else {
					result = bookDAO.findByCourse(keyword);
				}
			}
			else {
				result = bookDAO.findByTitle(keyword);
			}
		}	
		
		req.setAttribute("result", result);
		String listPage = "search_result.jsp";
		RequestDispatcher rd = req.getRequestDispatcher(listPage);
		rd.forward(req, res);
	}
	public void addBook(String title, String author, String desc) {
		Book book = new Book();
		book.setTitle(title);
		book.setAuthor(author);
		book.setDescription(desc);
		bookDAO.create(book);
		
	}

	public void CreateBook() throws IOException {
		String title = req.getParameter("title");
		String message = "";
		if(bookDAO.findByTitle(title) != null) {
			message = "Could not create book. Book \'" + title + "\' already exists.";
		}
		else {
			String author = req.getParameter("author");
			String desc = req.getParameter("desc");
			
			Book book = new Book();
			book.setTitle(title);
			book.setAuthor(author);
			book.setDescription(desc);
			
			String imagePath = "C:\\Users\\GFRD\\Documents\\340 project\\book images\\placeholder-.PNG";
			byte[] imageBytes = Files.readAllBytes(Paths.get(imagePath));
			book.setImage(imageBytes);
			
			bookDAO.create(book);
			message = "book created successfully";
		}
		res.getWriter().print(message);
	}

	public void editBook() throws IOException, ServletException {
		int bookId = Integer.parseInt(req.getParameter("id"));
		Book book = bookDAO.get(bookId);
		String editPage = "book_form.jsp";
		req.setAttribute("book", book);
		RequestDispatcher rd = req.getRequestDispatcher(editPage); 
		rd.forward(req, res);
		//res.getWriter().print(bookId);
//		Book book = bookDAO.get(bookId);
//		String editPage = "book_form.jsp";
//		req.setAttribute("book", book);
//		RequestDispatcher rd = req.getRequestDispatcher(editPage); 
//		rd.forward(req, res);
	}

	public void updateBook() throws ServletException, IOException {
		String message = "";
		int bookId = Integer.parseInt(req.getParameter("bookId"));
		String title = req.getParameter("title");
		String author = req.getParameter("author");
		String desc = req.getParameter("desc");
		
		Book fromId = bookDAO.get(bookId);
		Book fromTitle = bookDAO.findByTitle(title).get(0);
		//check they don't update title to another existing title
		if(fromTitle != null && fromTitle.getBookId() != fromId.getBookId()) {
			message = "Could not update book. Book title already exists. ";
		}
		else {
			Book book = new Book();
			book.setBookId(bookId);
			book.setTitle(title);
			book.setAuthor(author);
			book.setDescription(desc);
			
			bookDAO.update(book);
			message = "book updated";
			
		}
			System.out.println(message);
	}

	public void deleteBook() {
		int bookId = Integer.parseInt(req.getParameter("id"));
		bookDAO.delete(bookId);
		String message = "Book deleted.";
		System.out.println(message);
	}

	public void viewBookDetails() throws IOException, ServletException {
		int bookId = Integer.parseInt(req.getParameter("id"));
		Book book = bookDAO.get(bookId);
		req.setAttribute("book", book);
		
		String detailPage = "book_details.jsp";
		RequestDispatcher rd = req.getRequestDispatcher(detailPage);
		rd.forward(req, res);
	}
}
