package com.sample.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.sample.model.Parcel;

@Component
public class ParcelService {
	private String message;
	private double cost;
	private double volume;
	
	@Value("${HEAVY_PARCEL_MULTIPLIER}")
	private String heavyParcelMultiplier;
	
	@Value("${SMALL_PARCEL_MULTIPLIER}")
	private String smallParcelMultiplier;
	
	@Value("${MEDIUM_PARCEL_MULTIPLIER}")
	private String mediumParcelMultiplier;
		
	@Value("${LARGE_PARCEL_MULTIPLIER}")
	private String largeParcelMultiplier;

	public String showCalculatedValue(Parcel parcel) {
		if (isWeightExceeded(parcel.getWeight())) {
			return message;
		}
		volume = parcel.getHeight() * parcel.getWidth() * parcel.getLength();
		cost = calculateCost(parcel.getWeight(), volume);
		return	message;	
	}
	
	public boolean isWeightExceeded(double weight) {
		boolean exceeded = false;
		if (weight > 50) {
			//Reject
			message = "Reject. Weight limit exceeded! Not applicable";
			exceeded = true;
		}
		return exceeded;
	}
	

	
	public double calculateCost(double weight, double volume) {
		//heavy parcel
		if (weight > 10 && weight <= 50) {
			 cost = Double.parseDouble(heavyParcelMultiplier) * weight;
			 message = "Heavy Parcel. Cost: PHP" + cost;
		} else {
			//small parcel
			if (volume < 1500) {
				cost = Double.parseDouble(smallParcelMultiplier) * volume;
				message = "Small parcel. Cost: PHP" + cost;
			//medium parcel	
			} else if (volume > 1500 && volume < 2500) {
				cost = Double.parseDouble(mediumParcelMultiplier) * volume;
				message = "Medium parcel. Cost: PHP" + cost;
			} else {
			//large parcel
				cost = Double.parseDouble(largeParcelMultiplier) * volume;
				message = "Large parcel. Cost: PHP" + cost;
			}
		}
		return cost;
	}
	

	
}
