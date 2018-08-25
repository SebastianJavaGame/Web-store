package com.store.scislak.dataBase;

import java.util.List;

import com.store.scislak.encje.Client;

public interface ReadableDataBase {
	public List<Client> read();
	
	public Client readClient(String email);
}
