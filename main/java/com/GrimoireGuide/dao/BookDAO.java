package com.GrimoireGuide.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.GrimoireGuide.entity.Book;

public class BookDAO extends JpaDAO<Book> implements GenericDAO<Book> {

	public BookDAO(EntityManager em) {
		super(em);
	}
	public Book create(Book Book) {
		return super.create(Book);
	}
	@Override
	public Book update(Book Book) {
		return super.update(Book);
	}

	@Override
	public Book get(Object bookId) {
		return super.find(Book.class, bookId);
	}

	@Override
	public void delete(Object bookId) {
		super.delete(Book.class, bookId);
	}

	@Override
	public List<Book> listAll() {
		return super.findWithNamedQuery("Book.findAll");
	}

	@Override
	public long count() {
		return super.countWithNamedQuery("Book.countAll");
	}
	//find by keyword: title, author, desc..keyword in any of these
	public List<Book> findByTitle(String title) {
		List<Book> result = super.findWithNamedQuery("Book.findByTitle", "title", title);
		if(!result.isEmpty()) {
			return result;
		}
		return null;
	}
	public List<Book> search(String keyword) {
		return super.findWithNamedQuery("Book.search", "keyword", keyword);
	}
	public List<Book> findByCourse(String courseNumber) {
		List<Book> result = super.findWithNamedQuery("Book.findByCourse", "courseNumber", courseNumber);
		if(!result.isEmpty()) {
			return result;
		}
		return null;
	}
	

}
