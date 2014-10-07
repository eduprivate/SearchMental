package br.com.sentiment.persistence;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


public class Persister {
	
	@PersistenceContext
	protected EntityManager entityManager;
	
	public void saveEntity(Object object){
		entityManager.persist(object);
	}
	
	
	
	
}
