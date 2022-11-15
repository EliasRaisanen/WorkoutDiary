package com.example.workout.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, Long> {

	List<Person> findBysleep(String sleep);
	
	

}