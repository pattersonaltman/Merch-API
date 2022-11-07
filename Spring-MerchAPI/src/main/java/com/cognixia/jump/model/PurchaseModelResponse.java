package com.cognixia.jump.model;

public class PurchaseModelResponse {

	
	private Long user_id;
	
	private String username;
	
	private String email;
	
	private Hoodie hoodie;
	
	
	public PurchaseModelResponse() {
		
	}


	public PurchaseModelResponse(Long user_id, String username, String email, Hoodie hoodie) {
		super();
		this.user_id = user_id;
		this.username = username;
		this.email = email;
		this.hoodie = hoodie;
	}


	public Long getUser_id() {
		return user_id;
	}


	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public Hoodie getHoodie() {
		return hoodie;
	}


	public void setHoodie(Hoodie hoodie) {
		this.hoodie = hoodie;
	}


	@Override
	public String toString() {
		return "PurchaseModelResponse [user_id=" + user_id + ", username=" + username + ", email=" + email + ", hoodie="
				+ hoodie + "]";
	}
	
	
	
	
	
	
}
