package com.store.scislak.auth;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

public class ClientDetails implements com.store.scislak.auth.UserDetails {
	
	private UserDetails userDetails;
	
	public enum UserStatus{ADMIN, USER}
	private static UserStatus userStatus;
	
	private static int userId;
	
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


	public static UserStatus getUserStatus() {
		return userStatus;
	}
	
	public static void setUserId(int index) {
		userId = index;
	}
	
	public static int getUserId() {
		return userId;
	}

	public static void setUserStatus(UserStatus userStatus) {
		ClientDetails.userStatus = userStatus;
	}
}
