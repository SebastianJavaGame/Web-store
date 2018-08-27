package com.store.scislak.dataBase;

import java.util.List;

public interface ReadableDataBase {
	public List<?> read(String dataBase);
	
	public Object readClient(String email, String dataBase);
}
