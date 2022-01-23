package com.springApps.GreetingApp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springApps.GreetingApp.dto.Greeting;
import com.springApps.GreetingApp.repo.GreetingRepository;

@Service
public class GreetingService implements IGreetingService {

	private String message = "Hello %s %s!";
	
	@Autowired
	private GreetingRepository greetingRepo;

	@Override
	public Greeting message() {
		// TODO Auto-generated method stub
		return greetingRepo.save( new Greeting("Hello World!") );
	}

	@Override
	public Greeting message(String name) {
		// TODO Auto-generated method stub
		return greetingRepo.save( new Greeting("Hello " + name + "!") );
	}

	@Override
	public Greeting message(String firstName, String lastName) {
		// TODO Auto-generated method stub

		if (firstName.equals("") && lastName.equals("")) {
			return message();
		}

		else if (firstName.equals("")) {
			return message(lastName);
		} else if (lastName.equals("")) {
			return message(firstName);
		}

		return greetingRepo.save( new Greeting(String.format(message, firstName, lastName)) );
	}

}
