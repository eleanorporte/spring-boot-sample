package com.sample.model;

import javax.validation.constraints.NotBlank;


public class Parcel {
	private double height;
	private double weight;
	private double length;
	private double width;
	private double volume;
	
	public Parcel(double weight, double height, double length, double width) {
		super();
		this.height = Double.valueOf(height);
		this.weight = Double.valueOf(weight);
		this.length = Double.valueOf(length);
		this.width = Double.valueOf(width);
		
	}
	
	public double getHeight() {
		return height;
	}
	
	public double getWeight() {
		return weight;
	}
	
	public double getLength() {
		return length;
	}
	
	public double getWidth() {
		return width;
	}
	
	public double getVolume() {
		return volume;
	}	
}
