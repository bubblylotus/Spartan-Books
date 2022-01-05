package com.GrimoireGuide.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.GrimoireGuide.dao.GenericDAO;
import com.GrimoireGuide.dao.JpaDAO;

@Entity
@Table(name = "subject")
public class Subject{
	private Integer subjectId;
	private String name;
	private String abbr;
	private List<Course> courses = new ArrayList<Course>();
	
	@Column(name = "subject_id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getSubjectId() {
		return subjectId;
	}
	public void setSubjectId(Integer subjectId) {
		this.subjectId = subjectId;
	}
	@Column
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Column
	public String getAbbr() {
		return abbr;
	}
	public void setAbbr(String abbr) {
		this.abbr = abbr;
	}
	@OneToMany(mappedBy = "subject", cascade = CascadeType.ALL)
	public List<Course> getCourses() {
		return courses;
	}
	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
	
	
	
	
}
