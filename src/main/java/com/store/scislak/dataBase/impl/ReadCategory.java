package com.store.scislak.dataBase.impl;

import java.util.List;

public class ReadCategory extends ReadClientJPA{
	
	@SuppressWarnings("unchecked")
	public List<Object> readProductWithCategory(String dataBase, String category) {
		super.init();
		List<Object> listOfClient = null; 
		
		try {		
			if(!category.isEmpty())
				listOfClient = entityManager.createQuery("FROM " + dataBase + " where category='" + category + "'").getResultList();
			else
				listOfClient = entityManager.createQuery("FROM " + dataBase).getResultList();
			
			for(Object client: listOfClient)
				System.out.println(client.toString());
		}
		finally {
			cleanUp();
		}
		
		return (List<Object>)listOfClient;
	}
}
