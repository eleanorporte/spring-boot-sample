package com.sample.model;
import org.springframework.stereotype.Component;

@Component
public class PostResponse {
	int id;
	String message;
	
	public int getId() {
		return id;
	}
	public String getMessage() {
		return message;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public void setMessage(String message) {
		this.message = message;
	}

}