package io.altar.jseproject.model;

import io.altar.jseproject.repositories.ProductRepository;

public class Shelf extends Entity {
	
	// Attributes
	private int capacity;
	private Product product;
	private double price;
	
	/* Construct Shelf
	 * {int id} id of the shelf
	 * {int capacity} capacity of the shelf
	 * {Product product} Product in the shelf
	 * {double price} price of the product in the shelf
	 * 
	 */
	public Shelf(int capacity, double price) {
		this.capacity = capacity;
		this.price = price;
	}

	//Getters and Setters
	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	public void addProduct(){
		
	}
	
	@Override
	public String toString() {
		return "Shelf "+this.getId()+" [capacity=" + capacity + ", price=" + price  + "]";
	}
}
