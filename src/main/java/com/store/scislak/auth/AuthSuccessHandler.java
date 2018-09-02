package com.store.scislak.auth;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import com.store.scislak.auth.ClientDetails.UserStatus;

public class AuthSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler{

	@Override
	protected String determineTargetUrl(HttpServletRequest request, HttpServletResponse response) {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String role = authentication.getAuthorities().toString();
		String targetUrl = "";
		
		if(role.contains("ROLE_ADMIN")) {
			targetUrl = "/adminHome";
			ClientDetails.setUserStatus(UserStatus.ADMIN);
		}
		else if(role.contains("ROLE_USER")) {
			targetUrl = "/clientHome";
			ClientDetails.setUserStatus(UserStatus.USER);
		}
		
		return targetUrl;
	}
	
	
}
