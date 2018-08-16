package com.store.scislak.dataBase.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.store.scislak.dataBase.ReadableDataBase;
import com.store.scislak.encje.Client;
import com.store.scislak.encje.LoginDate;

public class ReadClient implements ReadableDataBase{

	/*
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Connection");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		try {
			Client client = new Client();
			client.setAddress("Ryki ul.S³owackiego 4a");
			client.setEmail("Bohdan14@tlen.pl");
			client.setLast_name("Wymaz");
			client.setName("Bogdan");
			client.setPostcode("08-500");
			
			LoginDate loginDate = new LoginDate();
			loginDate.setEmail(client.getEmail());
			loginDate.setPassword("private");
			loginDate.setAccess("USER");
			
			client.setLoginDate(loginDate);
			
			entityManager.getTransaction().begin();
			entityManager.persist(client);
			entityManager.persist(loginDate);
			entityManager.getTransaction().commit();
		}
		finally {
			entityManager.close();
			entityManagerFactory.close();
		}
	}
	*/
	/*
	public static void main(String[] args) {
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
	}
	*/
	
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
