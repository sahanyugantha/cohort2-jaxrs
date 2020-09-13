package com.cohort2.jerseyapp.model;

public class Car {
	
	private int id;
	private String model;
	private String brand;
	private int year;
	private CARTYPE type;
	
	public Car() {
		
	}
	
	

	public Car(int id, String model, String brand, int year, CARTYPE type) {
		super();
		this.id = id;
		this.model = model;
		this.brand = brand;
		this.year = year;
		this.type = type;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public CARTYPE getType() {
		return type;
	}

	public void setType(CARTYPE type) {
		this.type = type;
	}



//	@Override
//	public String toString() {
//		return "Car [id=" + id + ", model=" + model + ", brand=" + brand + ", year=" + year + ", type=" + type + "]";
//	}
	
	
	
}
