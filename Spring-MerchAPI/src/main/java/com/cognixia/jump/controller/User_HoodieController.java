package com.cognixia.jump.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import com.cognixia.jump.model.Hoodie;
import com.cognixia.jump.model.PurchaseModelRequest;
import com.cognixia.jump.model.PurchaseModelResponse;
import com.cognixia.jump.model.User;
import com.cognixia.jump.repository.HoodieRepository;
import com.cognixia.jump.repository.UserRepository;

@RestController
@RequestMapping("/api")
public class User_HoodieController {

	
	
	
	@Autowired
	HoodieRepository hoodieRepo;
	
	
	
	@Autowired
	UserRepository userRepo;
	
	
	
	
	// User purchase a Hoodie
	@PostMapping("/hoodie/cart")
	public ResponseEntity<?> addHoodieToCart(@RequestBody PurchaseModelRequest model) {
		
		Optional<Hoodie> hoodie	= hoodieRepo.findById(model.getHoodie_id());
		Optional<User> user = userRepo.findById(model.getUser_id());
		
		if(hoodie.isPresent())
		{
			if(hoodie.get().getQty() > 0)	// check if in stock
			{
				PurchaseModelResponse created = new PurchaseModelResponse(user.get().getUser_id(), user.get().getUsername(), user.get().getEmail(), hoodie.get());
				
				return ResponseEntity.status(201).body(created);
			}
		}
		
		return ResponseEntity.status(400).body("Hoodie with id [" + model.getHoodie_id() + "] is out of stock");
	}
	
	
	
	
	
	
	
	
	
	
	
	// Get all Hoodie purchases
	@GetMapping("/hoodie/allpurchases")
	public ResponseEntity<?> getAllHoodiePurchases(){
		
		
		return null;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}












