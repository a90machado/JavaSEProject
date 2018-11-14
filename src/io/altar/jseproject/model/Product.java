package io.altar.jseproject.model;

public class Product {

	// Attributes
	private int id;
	private Shelf[] listShelfs;
	private double discountPrice;
	private double iva;
	private double pvp;
	
	/* Construct Shelf
	 * {double discountPrice} Product discount
	 * {double iva} iva hover the Product
	 * {double pvp} pvp of the Product
	 * 
	 */
	public Product(double discountPrice, double iva, double pvp) {
		this.discountPrice = discountPrice;
		this.iva = iva;
		this.pvp = pvp;
	}

	//Getters and Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Shelf[] getListShelfs() {
		return listShelfs;
	}

	public void setListShelfs(Shelf[] listShelfs) {
		this.listShelfs = listShelfs;
	}

	public double getDiscountPrice() {
		return discountPrice;
	}

	public void setDiscountPrice(double discountPrice) {
		this.discountPrice = discountPrice;
	}

	public double getIva() {
		return iva;
	}

	public void setIva(double iva) {
		this.iva = iva;
	}

	public double getPvp() {
		return pvp;
	}

	public void setPvp(double pvp) {
		this.pvp = pvp;
	}
	
	
	
}