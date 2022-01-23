package com.springApps.GreetingApp.dto;

public class Greeting {

	private long id;
	private String message;

	public String getMessage() {
		return message;
	}

	public long getId() {
		return id;
	}

	public Greeting(long id, String message) {
		super();
		this.id = id;
		this.message = message;
	}

}
