package com.cognixia.jump.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

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

import com.cognixia.jump.exception.ResourceAlreadyExistsException;
import com.cognixia.jump.exception.ResourceNotFoundException;
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
	public ResponseEntity<?> createUser(@Valid @RequestBody User user) throws ResourceAlreadyExistsException {
		
		if(userRepo.existsById(user.getUser_id()))
		{
			throw new ResourceAlreadyExistsException("User", user.getUser_id());
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
	public Optional<User> getById(@PathVariable Long id) throws ResourceNotFoundException {
		
		Optional<User> found = userRepo.findById(id);
		
		if(found.isPresent())
		{
			return found;
		}
		
		throw new ResourceNotFoundException("User", id);
	}
	
	
	
	
	// Get user by username
	@GetMapping("/user/username/{username}")
	public Optional<User> getByUsername(@PathVariable String username) throws ResourceNotFoundException {	
		
		Optional<User> found = userRepo.findByUsername(username);
		
		if(found.isPresent())
		{
			return found;
		}
		
		throw new ResourceNotFoundException("User", username);
	}
	
	
	
	
	
	// Update user by id
	@PutMapping("/user/update")
	public ResponseEntity<?> updateUser(@RequestBody User user) throws ResourceNotFoundException {
		
		
		if(userRepo.existsById(user.getUser_id()))
		{
			user.setPassword(encoder.encode(user.getPassword()));	//re-encode password
			
			User updated = userRepo.save(user);
			
			return ResponseEntity.status(200).body(updated);
		}
		
		throw new ResourceNotFoundException("User", user.getUser_id());
	}
	
	
	
	
	
	// Update user by id - without updating id, with request model
	@PutMapping("/user/update/rqmodel")
	public ResponseEntity<?> updateUserRequestModel(@RequestBody UpdateUserModel model) throws ResourceNotFoundException {
		
		if(userServ.updateUserById(model))
		{
			return ResponseEntity.status(200).body(userRepo.findById(model.getIdToModify()));
		}
		
		throw new ResourceNotFoundException("User", model.getIdToModify());
	}
	
	
	
	
	
	// Delete
	@DeleteMapping("/user/delete/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable Long id) throws ResourceNotFoundException {
		
		if(userRepo.existsById(id))
		{
			User deleted = userRepo.findById(id).get();
			
			userRepo.deleteById(id);
			
			return ResponseEntity.status(200).body(deleted);
		}
		
		throw new ResourceNotFoundException("User", id);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}

























