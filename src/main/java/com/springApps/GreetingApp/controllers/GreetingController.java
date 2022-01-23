package com.springApps.GreetingApp.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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

@RestController
@RequestMapping("/greet")
public class GreetingController {
	
	@Autowired
	private IGreetingService greetingService;

	@GetMapping(value = { "", "/", "home" })
	public Greeting hello() {
		return greetingService.message();
	}

	@GetMapping("/query")
	public Greeting helloQuery(@RequestParam(value = "fName", defaultValue = "") String firstName,
			@RequestParam(value = "lName", defaultValue = "") String lastName) {
		return greetingService.message(firstName, lastName);
	}

	@GetMapping(value = { "/path/{fName}/{lName}", "/path/{fName}", "/path"})
	public Greeting helloPath(@PathVariable Optional<String> fName, @PathVariable Optional<String> lName) {
		String firstName = "";
		String lastName = "";

		if (fName.isPresent())
			firstName = fName.get();

		if (lName.isPresent())
			lastName = lName.get();

		return greetingService.message(firstName, lastName);

	}

	@PostMapping("/post")
	public Greeting helloPost(@RequestBody User user) {
		return greetingService.message(user.getFirstName(), user.getLastName());
	}

	@PutMapping(value = {"/put/{firstName}", "/put"})
	public Greeting hello(@PathVariable Optional<String> firstName, @RequestParam(value = "lName", defaultValue = "") String lastName) {
		String fName = "";
		
		if(firstName.isPresent()) {
			fName = firstName.get();
		}
		
		return greetingService.message(fName, lastName);
	}
	
	@GetMapping("/find/{id}")
	public Greeting findGreeting(@PathVariable String id) {
		return greetingService.findGreeting(id);
	}

}
