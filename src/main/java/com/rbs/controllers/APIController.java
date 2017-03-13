package com.rbs.controllers;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rbs.domains.Domain;
import com.rbs.domains.Stock;
import com.rbs.pojo.Greeting;
import com.rbs.pojo.Person;
import com.rbs.repository.Repository;

@RestController
public class APIController {

	@Autowired private Repository repository;

	@RequestMapping("/api/stocks")
	public List<Domain> greet(){
		return repository.findAll("Stock");
	}
	
	@RequestMapping("/api/stockDetails")
	public List<Domain> details(){
		return repository.findAll("StockDetail");
	}
	
	@RequestMapping(value="/api/hello", method=RequestMethod.POST,
			consumes="application/json", produces="application/json")
	public Greeting greeting(@RequestBody Person person){
		return new Greeting("Hello, " + person.getName());
	}
	
	@RequestMapping(value="/api/insert")
	public void insert(){
		repository.insert(new Stock("APPL", "", 12312, "" ,"", new Timestamp(System.currentTimeMillis())));
	}
	
}
