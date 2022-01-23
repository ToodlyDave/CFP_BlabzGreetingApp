package com.springApps.GreetingApp.services;

import java.util.List;

import com.springApps.GreetingApp.dto.Greeting;

public interface IGreetingService {

	public Greeting message();

	public Greeting message(String name);

	public Greeting message(String firstName, String lastName);
	
	public Greeting findGreeting(String id);
	
	public List<Greeting> showAllGreetings();

}
