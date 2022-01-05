package com.GrimoireGuide.dao;

import java.util.List;

public interface GenericDAO<E> {
public E create(E entity); //indicate generic type
	
	public E update(E entity);
	
	public E get(Object id);
	
	public void delete(Object id);
	
	public List<E> listAll(); //collection
	
	public long count();
}
