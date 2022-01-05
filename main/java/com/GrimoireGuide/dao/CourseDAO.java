package com.GrimoireGuide.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.GrimoireGuide.entity.Course;

public class CourseDAO extends JpaDAO<Course> implements GenericDAO<Course> {

	public CourseDAO(EntityManager em) {
		super(em);
	}

	public Course create(Course Course) {
		return super.create(Course);
	}
	@Override
	public Course update(Course Course) {
		return super.update(Course);
	}

	@Override
	public Course get(Object subjectId) {
		return super.find(Course.class, subjectId);
	}

	@Override
	public void delete(Object subjectId) {
		super.delete(Course.class, subjectId);
	}

	@Override
	public List<Course> listAll() {
		return super.findWithNamedQuery("Course.findAll");
	}

	@Override
	public long count() {
		return super.countWithNamedQuery("Course.countAll");
	}
	
}
