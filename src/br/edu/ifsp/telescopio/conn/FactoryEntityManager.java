package br.edu.ifsp.telescopio.conn;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FactoryEntityManager {
private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("telescopio");
	
	public static EntityManager getEntityManager() {
		return factory.createEntityManager();
	}
}
