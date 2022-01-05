package com.GrimoireGuide.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "source")
@NamedQuery(name = "Source.findAll", query = "SELECT s FROM Source s ORDER BY s.name")
@NamedQuery(name = "Source.countAll", query = "SELECT count(*) FROM Source s")
public class Source {
	private Integer sourceId;
	private String name;
	private double price;
	private Boolean isRent;
	private String link;
	private Book book;
	
	
	@Column(name = "source_id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getSourceId() {
		return sourceId;
	}
	public void setSourceId(Integer sourceId) {
		this.sourceId = sourceId;
	}
	@Column
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Column
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Column(name = "isRent")
	public Boolean isRent() {
		return isRent;
	}
	public void setRent(Boolean isRent) {
		this.isRent = isRent;
	}
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "book_id")
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	@Column
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	
	
	
}
