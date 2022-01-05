package com.GrimoireGuide.entity;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "book")
@NamedQuery(name = "Book.findAll", query = "SELECT b FROM Book b ORDER BY b.title")
@NamedQuery(name = "Book.countAll", query = "SELECT count(*) FROM Book b")
@NamedQuery(name = "Book.findByTitle", query = "SELECT b FROM Book b WHERE b.title = :title")
@NamedQuery(name = "Book.search", query = "SELECT b FROM Book b WHERE b.title LIKE '%' || :keyword || '%'"
		+ "OR b.author LIKE '%' || :keyword || '%'"
		+ "OR b.description LIKE '%' || :keyword || '%'")
@NamedQuery(name = "Book.findByCourse", query = "SELECT b FROM Book b "
		+ "JOIN b.courses c WHERE c.courseNumber = :courseNumber")
public class Book{
	private Integer bookId;
	//private Course course;
	private String title;
	private String author;
	private String description;
	private byte[] image;
	private String base64Image;
	private String img_link;
	//private Set sources = new HashSet(0);
	private List<Source> sources = new ArrayList<Source>();
	private List<Course> courses = new ArrayList<Course>();
	
	
	
	
	@Column(name = "book_id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getBookId() {
		return bookId;
	}
	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}
	@Column
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	@Column(name = "Author")
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	@Column
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
	public List<Source> getSources() {
		return sources;
	}
	public void setSources(List<Source> sources) {
		this.sources = sources;
	}
	@ManyToMany
	@JoinTable(
		name = "book_courses", 
		joinColumns = @JoinColumn(name = "book_id"), 
		inverseJoinColumns = @JoinColumn(name = "course_id")
		)
	public List<Course> getCourses() {
		return courses;
	}
	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
	@Column
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	@Transient
	public String getBase64Image() {
		this.base64Image = Base64.getEncoder().encodeToString(this.image);
		return this.base64Image;
	}
	public void setBase64Image(String base64Image) {
		this.base64Image = base64Image;
	}
	@Column
	public String getImg_link() {
		return img_link;
	}
	public void setImg_link(String img_link) {
		this.img_link = img_link;
	}
	
	
	
	
	
	
}
