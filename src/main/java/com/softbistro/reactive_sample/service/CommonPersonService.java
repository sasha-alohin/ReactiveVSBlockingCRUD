package com.softbistro.reactive_sample.service;

import java.time.Duration;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softbistro.reactive_sample.component.entities.Person;
import com.softbistro.reactive_sample.component.interfaces.CommonPersonRepository;
import com.softbistro.reactive_sample.component.interfaces.ReactivePersonRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CommonPersonService {

	@Autowired
	private CommonPersonRepository personRepository;

	public List<Person> listPerson() {
		return personRepository.findAll();
	}

	public List<Person> findByFirstName(String firstName) {
		return personRepository.findByFirstName(firstName);
	}

	public Person createPerson(Person person) {
		return personRepository.insert(person);
	}

	public List<Person> createManyPersons(List<Person> persons) {
		return personRepository.saveAll(persons);
	}

	public void deletePersonById(String id) {
		personRepository.deleteById(id);
	}

	public Person updatePerson(Person person) {
		return personRepository.save(person);
	}

}
