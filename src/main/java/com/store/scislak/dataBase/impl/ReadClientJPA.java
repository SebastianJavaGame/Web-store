package com.store.scislak.dataBase.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.store.scislak.dataBase.ReadableDataBase;

public class ReadClientJPA implements ReadableDataBase{
	
	private EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Object> read(String dataBase) {
		init();
		List<Object> listOfClient = null; 
		
		try {		
			listOfClient = entityManager.createQuery("FROM " + dataBase).getResultList();
			
			for(Object client: listOfClient)
				System.out.println(client.toString());
		}
		finally {
			cleanUp();
		}
		
		return (List<Object>)listOfClient;
	}

	@Override
	public Object readClient(String email, String dataBase) {
		init();
		Object object = null;
		
		try {			
			object = entityManager.createQuery("FROM " + dataBase + " WHERE email='" + email + "'").getSingleResult();
			
			System.out.println(object.toString());
		}
		finally {
			cleanUp();
		}
		
		return object;
	}
	
	private void init(){
		entityManagerFactory = Persistence.createEntityManagerFactory("Connection");
		entityManager = entityManagerFactory.createEntityManager();
	}
	
	private void cleanUp() {
		entityManager.close();
		entityManagerFactory.close();
	}
}
