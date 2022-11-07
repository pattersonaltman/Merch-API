package com.cognixia.jump.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognixia.jump.model.UpdateUserModel;
import com.cognixia.jump.model.User;
import com.cognixia.jump.repository.UserRepository;
import com.cognixia.jump.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {

	
	
	
	@Autowired
	UserRepository userRepo;
	
	
	
	@Autowired
	PasswordEncoder encoder;
	
	
	
	
	@Autowired
	UserService userServ;
	
	
	
	
	
	// Create a User (Authorizations: Anyone)
	@PostMapping("/user/create")
	public ResponseEntity<?> createUser(@RequestBody User user) {
		
		
		if(userRepo.existsById(user.getUser_id()))
		{
			return ResponseEntity.status(400).body("User with id: " + user.getUser_id() + " already exists");
		}
		
		user.setUser_id(null);	// might be trashable since id = null is not accepted [?]
		
		user.setPassword(encoder.encode(user.getPassword()));
		
		User created = userRepo.save(user);
		
		return ResponseEntity.status(201).body(created);
		
	}
	
	
	
	
	
	
	
	// Get all users (Authorization: JWT)
	@GetMapping("/user")
	public List<User> getAllUsers() {
		return userRepo.findAll();
	}
	
	
	
	
	// Get user by id
	@GetMapping("/user/id/{id}")
	public Optional<User> getById(@PathVariable Long id) {
		return userRepo.findById(id);
	}
	
	
	
	
	// Get user by username
	@GetMapping("/user/username/{username}")
	public Optional<User> getByUsername(@PathVariable String username) {	
		return userRepo.findByUsername(username);
	}
	
	
	
	
	
	// Update user by id
	@PutMapping("/user/update")
	public ResponseEntity<?> updateUser(@RequestBody User user) {
		
		
		if(userRepo.existsById(user.getUser_id()))
		{
			user.setPassword(encoder.encode(user.getPassword()));	//re-encode password
			
			User updated = userRepo.save(user);
			
			return ResponseEntity.status(200).body(updated);
		}
		
		return ResponseEntity.status(400).body("User with id: " + user.getUser_id() + " does not exist");
	}
	
	
	
	
	
	// Update user by id - without updating id, with request model
	@PutMapping("/user/update/rqmodel")
	public ResponseEntity<?> updateUserRequestModel(@RequestBody UpdateUserModel model) {
		
		if(userServ.updateUserById(model))
		{
			return ResponseEntity.status(200).body(userRepo.findById(model.getIdToModify()));
		}
		
		return ResponseEntity.status(400).body("User with id [" + model.getIdToModify() + "] does not exist");
	}
	
	
	
	
	
	// Delete
	@DeleteMapping("/user/delete/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable Long id) {
		
		if(userRepo.existsById(id))
		{
			User deleted = userRepo.findById(id).get();
			
			userRepo.deleteById(id);
			
			return ResponseEntity.status(200).body(deleted);
		}
		
		return ResponseEntity.status(400).body("User with id: " + id + " does not exist");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}

























