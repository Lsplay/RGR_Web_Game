package com.example.pvp_knights.Config;


import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class AuthConfig {

	public Authentication getCurrentLoggin() {
		Authentication auth=SecurityContextHolder.getContext().getAuthentication();
		return auth;
}
	
}
