package com.softbistro.reactive_sample.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.softbistro.reactive_sample.component.entities.Person;
import com.softbistro.reactive_sample.service.CommonPersonService;

@RestController
@RequestMapping("/common/person")
public class CommonPersonController {

	@Autowired
	private CommonPersonService personService;

	@GetMapping("/findByName")
	public List<Person> findByFirstName(@RequestParam String firstName) {
		return personService.findByFirstName(firstName);
	}

	@PostMapping("/create")
	public Person createPerson(@RequestBody Person person) {
		return personService.createPerson(person);
	}

	@PostMapping("/createMany")
	public List<Person> createManyPersons(@RequestBody List<Person> persons) {
		return personService.createManyPersons(persons);
	}

	@DeleteMapping("/delete/{id}")
	public void deletePersonById(@PathVariable String id) {
		personService.deletePersonById(id);
	}

	@PutMapping("/update")
	public Person updatePerson(@RequestBody Person person) {
		return personService.updatePerson(person);
	}

	@GetMapping("/all")
	public List<Person> listPerson() {
		return personService.listPerson();
	}

}
