package com.springApps.GreetingApp.services;

import com.springApps.GreetingApp.dto.Greeting;

public interface IGreetingService {

	public Greeting message();

	public Greeting message(String name);

	public Greeting message(String firstName, String lastName);

}
