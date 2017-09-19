package com.softbistro.reactive_sample.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softbistro.reactive_sample.component.entities.Person;
import com.softbistro.reactive_sample.component.interfaces.ReactivePersonRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ReactivePersonService {

	@Autowired
	private ReactivePersonRepository personRepository;

	public Flux<Person> listPerson() {
		return personRepository.findAll().log();
	}

	public Flux<Person> findByFirstName(String firstName) {
		return personRepository.findByFirstName(firstName).doOnNext(person -> System.out.println("In NEXT:" + person))
				.doOnComplete(() -> System.out.println("Retrieving completed")).log();
	}

	public Mono<Person> createPerson(Person person) {
		return personRepository.insert(person).log()
				.doOnError(throwable -> System.err.println("Error while creating object"));
	}

	public Flux<Person> createManyPersons(List<Person> persons) {
		return personRepository.saveAll(persons).log()
				.doOnError(throwable -> System.err.println("Error while creating object"));
	}

	public Mono<Void> deletePersonById(String id) {
		return personRepository.deleteById(id).log();
	}

	public Mono<Person> updatePerson(Person person) {
		return personRepository.save(person).log();
	}

}
