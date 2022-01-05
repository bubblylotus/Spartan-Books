package com.GrimoireGuide.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.GrimoireGuide.entity.Subject;

public class SubjectDAO extends JpaDAO<Subject> implements GenericDAO<Subject> {

	public SubjectDAO(EntityManager em) {
		super(em);
	}
	public Subject create(Subject subject) {
		return super.create(subject);
	}
	@Override
	public Subject update(Subject subject) {
		return super.update(subject);
	}

	@Override
	public Subject get(Object subjectId) {
		return super.find(Subject.class, subjectId);
	}

	@Override
	public void delete(Object subjectId) {
		super.delete(Subject.class, subjectId);
	}

	@Override
	public List<Subject> listAll() {
		return super.findWithNamedQuery("subject.findAll");
	}

	@Override
	public long count() {
		return super.countWithNamedQuery("subject.countAll");
	}

}
