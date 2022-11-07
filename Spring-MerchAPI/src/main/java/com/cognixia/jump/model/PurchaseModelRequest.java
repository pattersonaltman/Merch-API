package com.cognixia.jump.model;

public class PurchaseModelRequest {

	
	
	
	
	private Long user_id;
	private Long hoodie_id;
	
	
	public PurchaseModelRequest() {
		
	}


	public PurchaseModelRequest(Long user_id, Long hoodie_id) {
		super();
		this.user_id = user_id;
		this.hoodie_id = hoodie_id;
	}


	public Long getUser_id() {
		return user_id;
	}


	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}


	public Long getHoodie_id() {
		return hoodie_id;
	}


	public void setHoodie_id(Long hoodie_id) {
		this.hoodie_id = hoodie_id;
	}


	@Override
	public String toString() {
		return "PurchaseModel [user_id=" + user_id + ", hoodie_id=" + hoodie_id + "]";
	}
	
	
	
	
	
	
	
	
	
	
}
