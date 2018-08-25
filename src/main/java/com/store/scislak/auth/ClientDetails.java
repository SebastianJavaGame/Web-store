package com.store.scislak.auth;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

public class ClientDetails implements com.store.scislak.auth.UserDetails {
	
	private UserDetails userDetails;
	
	public void init() {
		userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	}


	@Override
	public String getUserName() {
		return userDetails.getUsername();
	}

	@Override
	public String getUserPassword() {
		return userDetails.getPassword();
	}
}
