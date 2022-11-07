package com.cognixia.jump.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.swagger.v3.oas.annotations.media.Schema;

// http://localhost:8080/swagger-ui/index.html
// http://localhost:8080/openapi.html

@Schema(description = "User")
@Entity
public class User implements Serializable {

	
	private static final long serialVersionUID = 1L;

	
	
	public static enum Role {
		ROLE_USER, ROLE_ADMIN
	}
	
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	// auto increment
	private Long user_id;
	
	@Column(unique = true, nullable = false)
	private String username;
	
	@Column(nullable = false)
	private String password;
	
	@NotBlank(message = "Email must not be blank")
	@Column(nullable = false)
	private String email;
	
	@Enumerated(EnumType.STRING)
	private Role role;
	
	@Column(columnDefinition = "boolean default true")
	private boolean enabled;
	
	@JsonIgnoreProperties("users")
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(
			name = "User_Hoodie",
			joinColumns = @JoinColumn(name = "user_id"),
			inverseJoinColumns = @JoinColumn(name = "hoodie_id")
			)
	private Set<Hoodie> hoodies = new HashSet<>();
	
	
	
	
	
	public User() {
		
	}




	
	//only really needs when we set up manually (testing, etc)
	public User(Long user_id, String username, String password, String email, Role role, boolean enabled) {
		super();
		this.user_id = user_id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.role = role;
		this.enabled = enabled;
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
		return "User [user_id=" + user_id + ", username=" + username + ", password=" + password + ", email=" + email
				+ ", role=" + role + ", enabled=" + enabled + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
