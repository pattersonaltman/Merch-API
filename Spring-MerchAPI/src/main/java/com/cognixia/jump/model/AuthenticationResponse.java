package com.cognixia.jump.model;

import java.io.Serializable;

public class AuthenticationResponse implements Serializable {

	private static final long serialVersionUID = 1L;

	
	
	private String jwt;
	
	
	
	
	// Constructors
	
	
	public AuthenticationResponse(String jwt) {
		this.jwt = jwt;
	}



	
	
	// Getters/Setters
	

	public String getJwt() {
		return jwt;
	}




	public void setJwt(String jwt) {
		this.jwt = jwt;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
