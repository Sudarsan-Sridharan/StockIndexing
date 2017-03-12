package com.rbs.controllers;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rbs.pojo.Greeting;
import com.rbs.pojo.Person;

@RestController
public class APIController {

	/*@RequestMapping("/")
	public String greet(){
		return "Hello World!";
	}*/

	@RequestMapping("/api/hello")
	public String greet(){
		return "Hello Arpit!";
	}
	
	@RequestMapping(value="/api/hello", method=RequestMethod.POST,
			consumes="application/json", produces="application/json")
	public Greeting greeting(@RequestBody Person person){
		return new Greeting("Hello, " + person.getName());
	}
	
}
