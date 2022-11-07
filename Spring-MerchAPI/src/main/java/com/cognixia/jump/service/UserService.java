package com.cognixia.jump.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.cognixia.jump.model.UpdateUserModel;
import com.cognixia.jump.model.User;
import com.cognixia.jump.repository.UserRepository;

@Service
public class UserService {

	
	
	
	@Autowired
	UserRepository userRepo;
	
	
	
	@Autowired
	PasswordEncoder encoder;
	
	
	
	
	/*
	 * Updates User by id
	 * 
	 * Notes:
	 * 	- all fields except user_id are able to passed in and updated through the UpdateUserModel
	 */
	public boolean updateUserById(UpdateUserModel model) {
		
		Optional<User> updateUser = userRepo.findById(model.getIdToModify());
		
		if(updateUser.isPresent())	// would if(updateUser != null) work too?
		{
			//update all fields
			updateUser.get().setUsername(model.getUsername());		//username
			updateUser.get().setPassword(encoder.encode(model.getPassword()));	//password
			updateUser.get().setEmail(model.getEmail());			//email
			updateUser.get().setRole(model.getRole());				//role
			updateUser.get().setEnabled(model.isEnabled());			//enabled

			userRepo.save(updateUser.get());
			
			return true;
		}
		
		return false;
	}
	
	
	
	
}
