package com.softbistro.reactive_sample.component.interfaces;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.softbistro.reactive_sample.component.entities.Person;

public interface CommonPersonRepository extends MongoRepository<Person, String>{
	public List<Person> findByFirstName(String firstName);
}
