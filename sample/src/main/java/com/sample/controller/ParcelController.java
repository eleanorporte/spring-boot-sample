package com.sample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sample.model.Parcel;
import com.sample.model.PostRequest;
import com.sample.model.PostResponse;
import com.sample.service.ParcelService;

@RestController
public class ParcelController {
	@Autowired
	private ParcelService service;
	private Parcel parcel;
		
	@RequestMapping(value="/calculate-parcel", method = RequestMethod.GET)
	public String showCalculateParcelPage(ModelMap model){
		return "calculate-parcel";
	}

	
	public String calculateView(Parcel parcel){
		String infoMessage = service.showCalculatedValue(parcel);
		return infoMessage;
	}
	
	
	@RequestMapping(value = "/calculate-parcel", method = RequestMethod.POST)
	public PostResponse Test(@RequestBody PostRequest inputPayload) {
		PostResponse response = new PostResponse();
		parcel = new Parcel(inputPayload.getWeight(), inputPayload.getHeight(), inputPayload.getLength(), inputPayload.getWidth());
		response.setMessage(calculateView(parcel));
		return response;
	}

	
}
