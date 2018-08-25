package com.store.scislak.dataBase.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.store.scislak.dataBase.ReadableDataBase;
import com.store.scislak.encje.Client;

public class ReadClientJPA implements ReadableDataBase{
	
	private EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Client> read() {
		init();
		List<Client> listOfClient = null; 
		
		try {			
			listOfClient = entityManager.createQuery("FROM Client").getResultList();	
			
			for(Client client: listOfClient)
				System.out.println(client.toString());
		}
		finally {
			cleanUp();
		}
		
		return listOfClient;
	}

	@Override
	public Client readClient(String email) {
		init();
		Client client = null;
		
		try {			
			client = (Client) entityManager.createQuery("FROM Client WHERE email='" + email + "'").getSingleResult();
			
			System.out.println(client.toString());
		}
		finally {
			cleanUp();
		}
		
		return client;
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
