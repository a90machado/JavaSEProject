// Packages:
package io.altar.jseproject.model;

// Imports:
import java.util.ArrayList;

// Class Model Product
public class Product extends Entity {

	// Fields:
	private ArrayList<Long> listShelfs;
	private double discountPrice;
	private double iva;
	private double pvp;

	// Constructor:
	public Product(double discountPrice, double iva, double pvp) {
		this.listShelfs = new ArrayList<Long>();
		this.discountPrice = discountPrice;
		this.iva = iva;
		this.pvp = pvp;
	}

	// Getters and Setters:
	public ArrayList<Long> getListShelfs() {
		return listShelfs;
	}

	public void setListShelfs(ArrayList<Long> listShelfs) {
		this.listShelfs = listShelfs;
	}
	//-------------------------------------------------------
	public double getDiscountPrice() {
		return discountPrice;
	}

	public void setDiscountPrice(double discountPrice) {
		this.discountPrice = discountPrice;
	}
	//-------------------------------------------------------
	public double getIva() {
		return iva;
	}

	public void setIva(double iva) {
		this.iva = iva;
	}
	//-------------------------------------------------------
	public double getPvp() {
		return pvp;
	}

	public void setPvp(double pvp) {
		this.pvp = pvp;
	}
	//-------------------------------------------------------
	
	// Add new ID Shelf to ListShelfs:
	public void addToListShelfs(Long e){
		this.listShelfs.add(e);
	}
	
	// Override method toString:
	@Override
	public String toString() {
		if (this.getListShelfs()==null){
			return "Product " + this.getId() + " [discountPrice=" + discountPrice + ", iva=" + iva + ", pvp=" + pvp +" " + "]";
		}else{
			return "Product " + this.getId() + " [discountPrice=" + discountPrice + ", iva=" + iva + ", pvp=" + pvp +" "+ getListShelfs().toString() + "]";
		}
	}

}
