package com.softbistro.reactive_sample.component.interfaces;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.softbistro.reactive_sample.component.entities.Person;

import reactor.core.publisher.Flux;

public interface ReactivePersonRepository extends ReactiveMongoRepository<Person, String>{
	public Flux<Person> findByFirstName(String firstName);
}
