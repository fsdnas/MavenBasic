package com.mobile.model;

public class Mobile {
	private String model;
	private String brand;
	private Integer mobileId;
	private String storage;
	private String os;
	private float price;

	public Mobile() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Mobile(String model, String brand, String storage, String os, float price) {
		super();
		this.model = model;
		this.brand = brand;
		this.storage = storage;
		this.os = os;
		this.price = price;
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

	public Integer getMobileId() {
		return mobileId;
	}

	public void setMobileId(Integer mobileId) {
		this.mobileId = mobileId;
	}

	public String getStorage() {
		return storage;
	}

	public void setStorage(String storage) {
		this.storage = storage;
	}

	public String getos() {
		return os;
	}

	public void setos(String os) {
		this.os = os;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Mobile [mobileId=" + mobileId + ", brand=" + brand + ", model=" + model + ", storage=" + storage
				+ ", os=" + os + ", price=" + price + "]";
	}

}
