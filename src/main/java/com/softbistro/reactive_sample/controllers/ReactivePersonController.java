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
import com.softbistro.reactive_sample.service.ReactivePersonService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/reactive/person")
public class ReactivePersonController {

	@Autowired
	private ReactivePersonService personService;

	@GetMapping("/findByName")
	public Flux<Person> findByFirstName(@RequestParam String firstName) {
		return personService.findByFirstName(firstName);
	}

	@PostMapping("/create")
	public Mono<Person> createPerson(@RequestBody Person person) {
		return personService.createPerson(person);
	}

	@PostMapping("/createMany")
	public Flux<Person> createManyPersons(@RequestBody List<Person> persons) {
		return personService.createManyPersons(persons);
	}

	@DeleteMapping("/delete/{id}")
	public Mono<Void> deletePersonById(@PathVariable String id) {
		return personService.deletePersonById(id);
	}

	@PutMapping("/update")
	public Mono<Person> updatePerson(@RequestBody Person person) {
		return personService.updatePerson(person);
	}

	@GetMapping("/allMono")
	public Mono<List<Person>> listPerson() {
		return personService.listPerson().collectList();
	}

	@GetMapping("/allFlux")
	public Flux<Person> listPersonFlux() {
		return personService.listPerson();
	}

}