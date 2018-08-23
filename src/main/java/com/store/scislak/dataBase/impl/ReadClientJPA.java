package com.store.scislak.dataBase.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.store.scislak.dataBase.ReadableDataBase;
import com.store.scislak.encje.Client;

public class ReadClientJPA implements ReadableDataBase{
	@SuppressWarnings("unchecked")
	@Override
	public List<Client> read() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Connection");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		List<Client> listOfClient = null; 
		
		try {			
			listOfClient = entityManager.createQuery("FROM Client").getResultList();	
			
			for(Client client: listOfClient) {
				System.out.println(client.toString());
			}
		}
		finally {
			entityManager.close();
			entityManagerFactory.close();
		}
		
		return listOfClient;
	}
}
