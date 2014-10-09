package br.com.sentiment.persistence;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class Persister {
	
	private EntityManagerFactory factory;
	
	public Persister() {
		this.factory = Persistence.createEntityManagerFactory("searchmental");
	}
	
	public void saveEntity(Object entity){
		EntityManager manager = factory.createEntityManager();

		manager.getTransaction().begin();
		manager.persist(entity);
		manager.getTransaction().commit();

		manager.close();
	}
	
	public static void main(String[] args) {
	    EntityManagerFactory factory = Persistence.
	          createEntityManagerFactory("searchmental");

	    factory.close();
	}
	
}