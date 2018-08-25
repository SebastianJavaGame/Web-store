package com.store.scislak.auth;

public interface UserDetails {
	public void init();
	
	public String getUserName();
	
	public String getUserPassword();
}
