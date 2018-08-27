package com.store.scislak.auth;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

public class AuthSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler{

	@Override
	protected String determineTargetUrl(HttpServletRequest request, HttpServletResponse response) {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String role = authentication.getAuthorities().toString();
		String targetUrl = "";
		
		if(role.contains("ROLE_ADMIN"))
			targetUrl = "/adminHome";
		else if(role.contains("ROLE_USER"))
			targetUrl = "/clientHome";
		
		return targetUrl;
	}
	
	
}
