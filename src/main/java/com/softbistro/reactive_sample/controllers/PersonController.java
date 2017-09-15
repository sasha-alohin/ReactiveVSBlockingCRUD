package com.softbistro.reactive_sample.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.softbistro.reactive_sample.component.entities.Person;
import com.softbistro.reactive_sample.service.PersonService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/person")
public class PersonController {

	@Autowired
	private PersonService personService;

	@GetMapping("/random")
	public Flux<Integer> generateRandom() {
		return Flux.range(0, 100);
	}

	@GetMapping("/findByName")
	public Flux<Person> findByFirstName(@RequestParam String firstName) {
		return personService.findByFirstName(firstName);
	}

	@PostMapping("/create")
	public Mono<Void> createPerson(@RequestBody Person person) {
		return personService.createPerson(person);
	}
	
	@PostMapping("/createMany")
	public Mono<Void> createManyPersons(@RequestBody List<Person> persons) {
		return personService.createManyPersons(persons);
	}

	@DeleteMapping("/delete/{id}")
	public Mono<Void> deletePersonById(@PathVariable Integer id) {
		return personService.deletePersonById(id);
	}

	@PostMapping("/update")
	public Mono<Void> updatePerson(@RequestBody Person person) {
		return personService.updatePerson(person);
	}

	@GetMapping("/all")
	public Flux<Person> listPerson() {
		return personService.listPerson();
	}

}
