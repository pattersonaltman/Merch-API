package com.cognixia.jump.model;

import com.cognixia.jump.model.User.Role;

// Model to be used in UserController to update a User
public class UpdateUserModel {

	
	private Long idToModify;	// User id to check if exists in order to update
	
	
//	private Long user_id;
	private String username;
	private String password;
	private String email;
	private Role role;
	private boolean enabled;
	
	
	
	
	
	public UpdateUserModel(Long idToModify, String username, String password, String email, Role role,
			boolean enabled) {
		super();
		this.idToModify = idToModify;
		this.username = username;
		this.password = password;
		this.email = email;
		this.role = role;
		this.enabled = enabled;
	}





	public Long getIdToModify() {
		return idToModify;
	}





	public void setIdToModify(Long idToModify) {
		this.idToModify = idToModify;
	}





	public String getUsername() {
		return username;
	}





	public void setUsername(String username) {
		this.username = username;
	}





	public String getPassword() {
		return password;
	}





	public void setPassword(String password) {
		this.password = password;
	}





	public String getEmail() {
		return email;
	}





	public void setEmail(String email) {
		this.email = email;
	}





	public Role getRole() {
		return role;
	}





	public void setRole(Role role) {
		this.role = role;
	}





	public boolean isEnabled() {
		return enabled;
	}





	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}





	@Override
	public String toString() {
		return "UpdateUserModel [idToModify=" + idToModify + ", username=" + username + ", password=" + password
				+ ", email=" + email + ", role=" + role + ", enabled=" + enabled + "]";
	}
	
	
	
	
	
	
	
	
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
}
