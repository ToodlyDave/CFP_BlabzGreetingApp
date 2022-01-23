package com.springApps.GreetingApp.controllers;

import java.util.concurrent.atomic.AtomicLong;

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
import com.springApps.GreetingApp.services.GreetingService;

@RestController
@RequestMapping("/greet")
public class GreetingController extends GreetingService {

	private AtomicLong id = new AtomicLong();
	private String message = " How are you doing %s %s?";

	@GetMapping(value = { "", "/", "home" })
	public Greeting hello() {
		return message();
	}

	@GetMapping("/query")
	public Greeting hello(@RequestParam(value = "name") String name) {
		return new Greeting(id.incrementAndGet(), " How are you doing " + name + "?");
	}

	@GetMapping("/path/{name}")
	public Greeting helloPath(@PathVariable String name) {
		return new Greeting(id.incrementAndGet(), " How are you doing " + name + "?");
	}

	@PostMapping("/post")
	public Greeting helloPost(@RequestBody User user) {
		return new Greeting(id.incrementAndGet(), String.format(message, user.getFirstName(), user.getLastName()));
	}

	@PutMapping("/put/{fName}")
	public Greeting hello(@PathVariable String fName, @RequestParam(value = "lName") String lName) {
		return new Greeting(id.incrementAndGet(), String.format(message, fName, lName));
	}

}
