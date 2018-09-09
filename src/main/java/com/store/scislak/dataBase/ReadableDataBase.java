package com.store.scislak.dataBase;

import java.util.List;

public interface ReadableDataBase {
	public List<?> readAll(String dataBase);
	
	public Object readClient(String email, String dataBase);
	
	public Object read(int id, String dataBase);

	List<Object> readList(int id, String fieldSearch, String dataBase);
}
