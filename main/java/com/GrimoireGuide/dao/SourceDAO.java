package com.GrimoireGuide.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.GrimoireGuide.entity.Source;

public class SourceDAO extends JpaDAO<Source> implements GenericDAO<Source> {
	public SourceDAO(EntityManager em) {
		super(em);
	}

	public Source create(Source Source) {
		return super.create(Source);
	}
	@Override
	public Source update(Source Source) {
		return super.update(Source);
	}

	@Override
	public Source get(Object subjectId) {
		return super.find(Source.class, subjectId);
	}

	@Override
	public void delete(Object subjectId) {
		super.delete(Source.class, subjectId);
	}

	@Override
	public List<Source> listAll() {
		return super.findWithNamedQuery("Source.findAll");
	}

	@Override
	public long count() {
		return super.countWithNamedQuery("Source.countAll");
	}
}
