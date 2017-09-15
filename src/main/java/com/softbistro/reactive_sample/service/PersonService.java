package com.softbistro.reactive_sample.service;

import java.time.Duration;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softbistro.reactive_sample.component.entities.Person;
import com.softbistro.reactive_sample.component.interfaces.PersonRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PersonService {

	@Autowired
	private PersonRepository personRepository;

	public Flux<Person> listPerson() {
		return personRepository.findAll().log();
	}

	public Flux<Person> findByFirstName(String firstName) {
		return personRepository.findByFirstName(firstName).doOnNext(person -> System.out.println("In NEXT:" + person))
				.doOnComplete(() -> System.out.println("Retrieving completed")).timeout(Duration.ofSeconds(2))
				.filter(person -> person.getAge() > 1).log();
	}

	public Mono<Void> createPerson(Person person) {
		return personRepository.insert(person).log()
				.doOnError(throwable -> System.err.println("Error while creating object")).then();
	}

	public Mono<Void> createManyPersons(List<Person> persons) {
		return personRepository.saveAll(persons).log()
				.doOnError(throwable -> System.err.println("Error while creating object")).then();
	}
	
	public Mono<Void> deletePersonById(Integer id) {
		return personRepository.deleteById(id).log();
	}

	public Mono<Void> updatePerson(Person person) {
		return personRepository.save(person).log().then();
	}

}
