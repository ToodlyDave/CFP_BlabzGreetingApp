package com.springApps.GreetingApp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springApps.GreetingApp.dto.Greeting;
import com.springApps.GreetingApp.repo.GreetingRepository;

// This class makes up the service layer. We use the service annotation to identify this 
// class as a component in the service layer and this will later be useful when spring boot auto
// scans for components to use for the autowire annotation
@Service
public class GreetingService implements IGreetingService {

	private String message = "Hello %s %s!";

	// We inject the repository here
	@Autowired
	private GreetingRepository greetingRepo;

	// This will save a greeting with the default message into the repo
	@Override
	public Greeting message() {
		// TODO Auto-generated method stub
		return greetingRepo.save(new Greeting("Hello World!"));
	}

	// This will save a greeting with your name into the repo
	@Override
	public Greeting message(String name) {
		// TODO Auto-generated method stub
		return greetingRepo.save(new Greeting("Hello " + name + "!"));
	}

	// This will call the correct message method or save a greeting with your full
	// name into the repo.
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

		return greetingRepo.save(new Greeting(String.format(message, firstName, lastName)));
	}

	// This method finds greetings by id and returns the greeting found or a
	// greeting with an error message
	@Override
	public Greeting findGreeting(String id) {
		// TODO Auto-generated method stub

		Optional<Greeting> greeting = greetingRepo.findById(Long.parseLong(id));

		if (greeting.isPresent())
			return greeting.get();
		else
			return (new Greeting(-1, " Greeting not found!"));
	}

	// This method returns all the greetings stored in the repo
	@Override
	public List<Greeting> showAllGreetings() {
		// TODO Auto-generated method stub
		return (List<Greeting>) greetingRepo.findAll();
	}

	// This method updates a greeting stored in the repo. It will return the new
	// greeting or a greeting with an error message if the greeting to be updates
	// does not exist.
	@Override
	public Greeting updateGreeting(Greeting greeting) {
		// TODO Auto-generated method stub
		if (greetingRepo.findById(greeting.getId()).isPresent())
			return greetingRepo.save(greeting);
		else
			return new Greeting(-1, " Greeting not found!");
	}

	// This method deletes a greeting and returns a greeting with the operation
	// success/failure message
	@Override
	public Greeting deleteGreeting(String id) {
		// TODO Auto-generated method stub
		if (greetingRepo.findById(Long.parseLong(id)).isPresent()) {
			greetingRepo.deleteById(Long.parseLong(id));
			return new Greeting(-1, " Greeting deleted!");
		} else
			return new Greeting(-1, " No such greeting!");
	}

}
