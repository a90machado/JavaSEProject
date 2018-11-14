package io.altar.jseproject.model;

public class Shelf {
	
	// Attributes
	private int id;
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
	public Shelf(int capacity, Product product, double price) {
		this.capacity = capacity;
		this.product = product;
		this.price = price;
	}

	//Getters and Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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
	

}
