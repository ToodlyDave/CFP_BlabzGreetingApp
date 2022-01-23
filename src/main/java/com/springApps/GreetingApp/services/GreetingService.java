package com.springApps.GreetingApp.services;

import java.util.List;
import java.util.Optional;

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

	@Override
	public Greeting findGreeting(String id) {
		// TODO Auto-generated method stub
		
		Optional<Greeting> greeting = greetingRepo.findById(Long.parseLong(id));
		
		if (greeting.isPresent() )
			return greeting.get();
		else
			return (new Greeting(-1, " Greeting not found!"));
	}

	@Override
	public List<Greeting> showAllGreetings() {
		// TODO Auto-generated method stub
		return (List<Greeting>) greetingRepo.findAll();
	}
	
	

}
