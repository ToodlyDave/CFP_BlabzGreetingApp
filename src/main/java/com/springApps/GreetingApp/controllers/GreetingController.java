package com.springApps.GreetingApp.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springApps.GreetingApp.dto.Greeting;
import com.springApps.GreetingApp.dto.User;
import com.springApps.GreetingApp.services.IGreetingService;

// This is the controller class

@RestController
@RequestMapping("/greet")
// The controller will be monitoring the /greet path
public class GreetingController {

	// We use autowired annotation to inject the GreetingService service via the
	// interface
	@Autowired
	private IGreetingService greetingService;

	// This is a method to display a welcome message for http get methods at /home
	// or /
	@GetMapping(value = { "", "/", "home" })
	public Greeting hello() {
		return greetingService.message();
	}

	// This method accepts request parameters from http get method and passes them
	// on to the service layer
	@GetMapping("/query")
	public Greeting helloQuery(@RequestParam(value = "fName", defaultValue = "") String firstName,
			@RequestParam(value = "lName", defaultValue = "") String lastName) {
		return greetingService.message(firstName, lastName);
	}

	// This method accepts http get methods and accepts parameters via the path. It
	// then passes them on to the service layer.
	// It initializes two strings in case there are no variables provided in the
	// path.
	@GetMapping(value = { "/path/{fName}/{lName}", "/path/{fName}", "/path" })
	public Greeting helloPath(@PathVariable Optional<String> fName, @PathVariable Optional<String> lName) {
		String firstName = "";
		String lastName = "";

		if (fName.isPresent())
			firstName = fName.get();

		if (lName.isPresent())
			lastName = lName.get();

		return greetingService.message(firstName, lastName);

	}

	// This method accepts http post methods and accepts a json as a parameter
	@PostMapping("/post")
	public Greeting helloPost(@RequestBody User user) {
		return greetingService.message(user.getFirstName(), user.getLastName());
	}

	// This method accepts http put methos and accepts both path and request query
	// variables
	@PutMapping(value = { "/put/{firstName}", "/put" })
	public Greeting hello(@PathVariable Optional<String> firstName,
			@RequestParam(value = "lName", defaultValue = "") String lastName) {
		String fName = "";

		if (firstName.isPresent()) {
			fName = firstName.get();
		}

		return greetingService.message(fName, lastName);
	}

	// This method passes the greeting id to the service layer to search the repo
	@GetMapping("/find/{id}")
	public Greeting findGreeting(@PathVariable String id) {
		return greetingService.findGreeting(id);
	}

	// This method calls the service layer and returns a list of all the greetings
	// stored.
	@GetMapping("/show")
	public List<Greeting> showGreetings() {
		return greetingService.showAllGreetings();
	}

	// This method passes a greeting object to the service layer for updating an
	// existing greeting
	@PutMapping("/update")
	public Greeting updateGreeting(@RequestBody Greeting greeting) {
		return greetingService.updateGreeting(greeting);
	}

	// This method passes the id of the greeting to be deleted to the service layer.
	@DeleteMapping("/delete/{id}")
	public Greeting deleteGreeting(@PathVariable String id) {
		return greetingService.deleteGreeting(id);
	}

}
