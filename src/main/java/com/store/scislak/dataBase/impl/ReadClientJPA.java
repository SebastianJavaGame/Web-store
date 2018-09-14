package com.store.scislak.dataBase.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.store.scislak.dataBase.ReadableDataBase;

public class ReadClientJPA implements ReadableDataBase{
	
	protected EntityManagerFactory entityManagerFactory;
	protected EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Object> readAll(String dataBase) {
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
	
	@Override
	public Object read(int id, String dataBase) {
		init();
		Object object = null;
		
		try {			
			object = entityManager.createQuery("FROM " + dataBase + " WHERE id='" + id + "'").getSingleResult();
			
			System.out.println(object.toString());
		}
		finally {
			cleanUp();
		}
		
		return object;
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Object> readList(int id, String fieldSearch, String dataBase) {
		init();
		List<Object> objects = null;
		
		try {			
			objects = entityManager.createQuery("FROM " + dataBase + " WHERE " + fieldSearch + "='" + id + "'").getResultList();
			
			System.out.println(objects.toString());
		}
		finally {
			cleanUp();
		}
		
		return objects;
	}
	
	
	protected void init(){
		entityManagerFactory = Persistence.createEntityManagerFactory("Connection");
		entityManager = entityManagerFactory.createEntityManager();
	}
	
	protected void cleanUp() {
		entityManager.close();
		entityManagerFactory.close();
	}
}
