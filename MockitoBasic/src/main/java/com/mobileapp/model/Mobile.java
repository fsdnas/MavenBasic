package com.mobileapp.model;

public class Mobile {

	private String model;
	private String brand;
	private double price;
	private Integer mobileId;

	public Mobile() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Mobile(String model, String brand, double price, int mobileId) {
		super();
		this.model = model;
		this.brand = brand;
		this.price = price;
		this.mobileId = mobileId;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getMobileId() {
		return mobileId;
	}

	public void setMobileId(int mobileId) {
		this.mobileId = mobileId;
	}

	@Override
	public String toString() {
		return "Mobile [model=" + model + ", brand=" + brand + ", price=" + price + ", mobileId=" + mobileId + "]";
	}

}
