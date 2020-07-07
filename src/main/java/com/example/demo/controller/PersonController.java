package com.example.demo.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Person;
import com.example.demo.service.PersonService;

@RestController
public class PersonController {

	@Autowired
	private  PersonService personService;
	
	@RequestMapping(value="/create")
	public String create (@RequestParam String firstName,@RequestParam String lastName,@RequestParam int age) {
	     Person p = personService.save(firstName, lastName, age);
		return p.toString();
	}
	
	@RequestMapping(value = "/get")
	public Person getFirstName(@RequestParam String firstName) {
		return personService.getFirstName(firstName);
	}
	
	@RequestMapping( value ="/getAll")
   public List<Person> getAll(){
		return personService.getAll();
	}
	
	@RequestMapping(value ="/update")
	
	public String update(@RequestParam String firstName,@RequestParam String lastName,@RequestParam int age) {
		Person p  = personService.update(firstName, lastName, age);
		return p.toString();
	}
	
	@RequestMapping(value ="/delete")
	public String delete(@RequestParam String firstName) {
		personService.delete(firstName);
		return "Delete "  + firstName;
	}
	
	@RequestMapping(value="/deleteAll")
    public String deleteAll() {
		personService.deleteAll();
		return "Delete All ";
	}
    
}
