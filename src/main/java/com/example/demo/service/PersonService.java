package com.example.demo.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Person;
import com.example.demo.repository.PersonRepository;

@Service
public class PersonService {
	@Autowired
	private PersonRepository personRepository;
	
	public Person save(String nombre, String apellido,int edad) {
		return personRepository.save(new Person(nombre,apellido,edad));	
	}

	public List<Person> getAll() {
		return personRepository.findAll();
	}
	
	public Person getFirstName(String nombre) {
	  return personRepository.findByFirstName(nombre);
	}
	
	public Person update(String nombre, String apellido, int edad) {
		Person p = personRepository.findByFirstName(nombre) ;
		p.setLastName(apellido);
		p.setAge(edad);
		return personRepository.save(p);
	}
	
	public void  deleteAll() {
		personRepository.deleteAll();
	}
	
	public void delete(String nombre) {
		Person p = personRepository.findByFirstName(nombre) ;
		personRepository.delete(p);
	}
}
