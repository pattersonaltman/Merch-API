package com.cognixia.jump.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cognixia.jump.model.Hoodie;
import com.cognixia.jump.model.Hoodie.Color;
import com.cognixia.jump.model.Hoodie.Material;
import com.cognixia.jump.model.Hoodie.Size;

@Repository
public interface HoodieRepository extends JpaRepository<Hoodie, Long> {

	
	
	
	public Optional<Hoodie> findBySize(Size size);
	
	
	
	public Optional<Hoodie> findByColor(Color color);
	
	
	
	public Optional<Hoodie> findByMaterial(Material material);
	
	
	
	@Query(value = "SELECT u FROM hoodie WHERE u.price >= 10.00", nativeQuery = true)
	public Optional<Hoodie> findAllHoodiesOnClearance();
	

	
	
	
	
}
