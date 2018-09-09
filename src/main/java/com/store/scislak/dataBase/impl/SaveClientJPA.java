package com.store.scislak.dataBase.impl;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.store.scislak.dataBase.SaveableDataBase;

public class SaveClientJPA implements SaveableDataBase{

	@Override
	public void save(Serializable serializable) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Connection");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		try {			
			Object object = serializable;
			entityManager.getTransaction().begin();
			entityManager.persist(object);
			entityManager.getTransaction().commit();
		}
		catch(Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
		}
		finally {
			entityManager.close();
			entityManagerFactory.close();
		}
	}
}
