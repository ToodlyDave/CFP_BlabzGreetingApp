package com.springApps.GreetingApp.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

// We use the entity annotation so that spring boot will use this class for creating or updating a table in the database
@Entity
public class Greeting {

	// The id annotation is used to identify the primary key in the table. We also
	// auto-increment the value of id for each record inserted.
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
