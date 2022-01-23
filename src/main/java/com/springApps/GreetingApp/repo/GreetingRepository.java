package com.springApps.GreetingApp.repo;

import org.springframework.data.repository.CrudRepository;

import com.springApps.GreetingApp.dto.Greeting;

public interface GreetingRepository extends CrudRepository<Greeting, Long>{

}
