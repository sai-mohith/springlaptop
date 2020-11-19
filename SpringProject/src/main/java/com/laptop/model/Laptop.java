package com.laptop.model;

import javax.swing.Spring;

public class Laptop {
	
	Integer laptopId;
	Spring name;
	Spring category;
	Spring model;
	Double price;
	public Laptop() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Laptop(Integer laptopId, Spring name, Spring category, Spring model, Double price) {
		super();
		this.laptopId = laptopId;
		this.name = name;
		this.category = category;
		this.model = model;
		this.price = price;
	}
	public Integer getLaptopId() {
		return laptopId;
	}
	public void setLaptopId(Integer laptopId) {
		this.laptopId = laptopId;
	}
	public Spring getName() {
		return name;
	}
	public void setName(Spring name) {
		this.name = name;
	}
	public Spring getCategory() {
		return category;
	}
	public void setCategory(Spring category) {
		this.category = category;
	}
	public Spring getModel() {
		return model;
	}
	public void setModel(Spring model) {
		this.model = model;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Laptops [laptopId=" + laptopId + ", name=" + name + ", category=" + category + ", model=" + model
				+ ", price=" + price + "]";
	}
	
	
	

}
