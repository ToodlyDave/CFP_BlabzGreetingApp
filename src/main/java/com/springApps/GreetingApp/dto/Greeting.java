package com.springApps.GreetingApp.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Greeting {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String message;
	
	public Greeting() {
		// TODO Auto-generated constructor stub
	}

	public String getMessage() {
		return message;
	}

	public long getId() {
		return id;
	}

	public Greeting(String message) {
		super();
		this.message = message;
	}

	public Greeting(long id, String message) {
		super();
		this.id = id;
		this.message = message;
	}
	
	

}
