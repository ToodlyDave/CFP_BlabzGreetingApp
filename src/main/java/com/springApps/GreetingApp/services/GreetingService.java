package com.springApps.GreetingApp.services;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import com.springApps.GreetingApp.dto.Greeting;

@Service
public class GreetingService implements IGreetingService {

	private AtomicLong id = new AtomicLong();

	@Override
	public Greeting message() {
		// TODO Auto-generated method stub
		return new Greeting(id.incrementAndGet(), "Hello World!");
	}

}
