package com.springApps.GreetingApp.services;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import com.springApps.GreetingApp.dto.Greeting;

@Service
public class GreetingService implements IGreetingService {

	private AtomicLong id = new AtomicLong();
	private String message = "Hello %s %s!";

	@Override
	public Greeting message() {
		// TODO Auto-generated method stub
		return new Greeting(id.incrementAndGet(), "Hello World!");
	}

	@Override
	public Greeting message(String name) {
		// TODO Auto-generated method stub
		return new Greeting(id.incrementAndGet(), "Hello " + name + "!");
	}

	@Override
	public Greeting message(String firstName, String lastName) {
		// TODO Auto-generated method stub
		
		if (firstName.equals("") && lastName.equals("")) {
			return message();
		}
		
		else if (firstName.equals("")) {
			return message(lastName);
		}
		else if (lastName.equals("")) {
			return message(firstName);
		}
		
		return new Greeting(id.incrementAndGet(), String.format(message, firstName, lastName));
	}

}
