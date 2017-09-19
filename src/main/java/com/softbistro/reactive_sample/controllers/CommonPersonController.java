package com.softbistro.reactive_sample.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.softbistro.reactive_sample.component.entities.Person;
import com.softbistro.reactive_sample.service.CommonPersonService;
import com.softbistro.reactive_sample.service.ReactivePersonService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

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

	@PostMapping("/update")
	public Person updatePerson(@RequestBody Person person) {
		return personService.updatePerson(person);
	}

	@GetMapping("/all")
	public List<Person> listPerson() {
		return personService.listPerson();
	}

	@PostMapping("/post")
	public List<Person> postFilteredToDB(@RequestBody List<Person> persons) {
		System.out.println("In main");
		return persons;
	}

}