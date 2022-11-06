package com.cognixia.jump.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Hoodie implements Serializable {

	
	private static final long serialVersionUID = 1L;

	
	//Set up Enums for: size, color, material
	
	public static enum Size {
		SMALL, MEDIUM, LARGE
	}
	
	
	public static enum Color {
		RED, BLUE, GREEN, ORANGE,
		YELLOW, PURPLE, BLACK, WHITE
	}
	
	
	public static enum Material {
		FLEECE, COTTON, WOOL, VELVET, DENIM, NYLON
	}
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	// auto increment
	private Long hoodie_id;
	
	@Enumerated(EnumType.STRING)
	private Size size;
	
	@Enumerated(EnumType.STRING)
	private Color color;
	
	@Enumerated(EnumType.STRING)
	private Material material;
	
	@Column(nullable = false, columnDefinition = "DECIMAL(10,2)")	// columnDefinition to define price column and set to 2 decimal places
	private double price;
	
	@Column(nullable = false)
	private int qty;
	
	
	
	
	

	
	public Hoodie() {
		
	}







	public Hoodie(Long hoodie_id, Size size, Color color, Material material, double price, int qty) {
		super();
		this.hoodie_id = hoodie_id;
		this.size = size;
		this.color = color;
		this.material = material;
		this.price = price;
		this.qty = qty;
	}







	public Long getHoodie_id() {
		return hoodie_id;
	}







	public void setHoodie_id(Long hoodie_id) {
		this.hoodie_id = hoodie_id;
	}







	public Size getSize() {
		return size;
	}







	public void setSize(Size size) {
		this.size = size;
	}







	public Color getColor() {
		return color;
	}







	public void setColor(Color color) {
		this.color = color;
	}







	public Material getMaterial() {
		return material;
	}







	public void setMaterial(Material material) {
		this.material = material;
	}







	public double getPrice() {
		return price;
	}







	public void setPrice(double price) {
		this.price = price;
	}







	public int getQty() {
		return qty;
	}







	public void setQty(int qty) {
		this.qty = qty;
	}







	@Override
	public String toString() {
		return "Hoodie [hoodie_id=" + hoodie_id + ", size=" + size + ", color=" + color + ", material=" + material
				+ ", price=" + price + ", qty=" + qty + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
