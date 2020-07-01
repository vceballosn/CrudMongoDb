package com.example.demo.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Person;
import com.example.demo.service.PersonService;

@RestController
public class PersonController {

	@Autowired
	private  PersonService personService;
	
	@RequestMapping("/create")
	
	public String create (@RequestParam String nombre,@RequestParam String apellido,@RequestParam int edad) {
	     Person p = personService.guardar(nombre, apellido, edad);
		return p.toString();
	}
	
	@RequestMapping("/get")
	public Person getPerson(@RequestParam String nombre) {
		return personService.getFirstName(nombre);
	}
	
	@RequestMapping("/getAll")
   public List<Person> getAll(){
		return personService.obtenerTodos();
	}
	
	@RequestMapping("/update")
	
	public String update(@RequestParam String nombre,@RequestParam String apellido,@RequestParam int edad) {
		Person p  = personService.modificar(nombre, apellido, edad);
		return p.toString();
	}
	
	@RequestMapping("/delete")
	public String delete(@RequestParam String nombre) {
		personService.delete(nombre);
		return "Borrado "  + nombre;
	}
	
	@RequestMapping("/deleteAll")
    public String deleteAll() {
		personService.borrarTodos();
		return "Borrado todos los Registros ";
	}
    
}
