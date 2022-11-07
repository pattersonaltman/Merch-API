package com.cognixia.jump.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognixia.jump.exception.ResourceAlreadyExistsException;
import com.cognixia.jump.exception.ResourceNotFoundException;
import com.cognixia.jump.model.Hoodie;
import com.cognixia.jump.model.Hoodie.Color;
import com.cognixia.jump.model.Hoodie.Material;
import com.cognixia.jump.model.Hoodie.Size;
import com.cognixia.jump.repository.HoodieRepository;

@RestController
@RequestMapping("/api")
public class HoodieController {

	
	
	
	
	@Autowired
	HoodieRepository hoodieRepo;
	
	
	
	
	
	
	
	
	
	// Get all hoodies
	@GetMapping("/hoodie")
	public List<Hoodie> getAllHoodies() {
		return hoodieRepo.findAll();
	}
	
	
	
	
	
	
	
	
	
	// Create a Hoodie (Authorizations: )
	@PostMapping("/hoodie/create")
	public ResponseEntity<?> createHoodie(@RequestBody Hoodie hoodie) throws ResourceAlreadyExistsException {
		
		if(hoodieRepo.existsById(hoodie.getHoodie_id()))
		{
			throw new ResourceAlreadyExistsException("Hoodie", hoodie.getHoodie_id());
		}
		
		hoodie.setHoodie_id(null);	//trashable [?]
		
		Hoodie created = hoodieRepo.save(hoodie);
		
		return ResponseEntity.status(201).body(created);
	}
	
	
	
	
	
	
	
	
	// Get a Hoodie by size
	@GetMapping("/hoodie/size/{size}")
	public ResponseEntity<?> getHoodieBySize(@PathVariable Size size) throws ResourceNotFoundException {
		
		Optional<Hoodie> found = hoodieRepo.findBySize(size);
		
		if(found.isPresent())
		{
			return ResponseEntity.status(200).body(found);
		}
		
		throw new ResourceNotFoundException("Hoodie", "size", size.name());
	}
	
	
	
	
	// Get a Hoodie by color
	@GetMapping("/hoodie/color/{color}")
	public ResponseEntity<?> getHoodieByColor(@PathVariable Color color) throws ResourceNotFoundException {
		
	 	Optional<Hoodie> found = hoodieRepo.findByColor(color);
		
		if(found.isPresent())
		{
			return ResponseEntity.status(200).body(found);
		}
		
		throw new ResourceNotFoundException("Hoodie", "color", color.name());
	}
	
	
	
	
	// Get a Hoodie by material
	@GetMapping("/hoodie/material/{material}")
	public ResponseEntity<?> getHoodieByMaterial(@PathVariable Material material) throws ResourceNotFoundException {
		
		Optional<Hoodie> found = hoodieRepo.findByMaterial(material);
		
		if(found.isPresent())
		{
			return ResponseEntity.status(200).body(found);
		}
		
		throw new ResourceNotFoundException("Hoodie", "material", material.name());
	}
	
	
	
	
	
	
	
	
	
	// Get all Hoodies on clearance
	@GetMapping("/hoodie/clearance")
	public Optional<Hoodie> getHoodiesOnClearance() {
		return hoodieRepo.findAllHoodiesOnClearance();
	}
	
	

	
	
	
	
	
}




























