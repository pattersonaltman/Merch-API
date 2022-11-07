package com.cognixia.jump.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognixia.jump.model.User;
import com.cognixia.jump.repository.UserRepository;

@RestController
@RequestMapping("/api")
public class UserController {

	
	
	
	@Autowired
	UserRepository userRepo;
	
	
	
	@Autowired
	PasswordEncoder encoder;
	
	
	
	
	
	// Create a User (Authorizations: Anyone)
	@PostMapping("/user/create")
	public ResponseEntity<?> createUser(@RequestBody User user) {
		
		
		if(userRepo.existsById(user.getUser_id()))
		{
			return ResponseEntity.status(400).body("User with id: [" + user.getUser_id() + "] already exists");
		}
		
		user.setUser_id(null);	// might be trashable since id = null is not accepted [?]
		
		user.setPassword(encoder.encode(user.getPassword()));
		
		User created = userRepo.save(user);
		
		return ResponseEntity.status(201).body(created);
		
	}
	
	
	
	
	
	
	
	
	@GetMapping("/user")
	public List<User> getAllUsers() {
		return userRepo.findAll();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}

























