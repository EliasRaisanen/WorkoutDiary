package com.example.workout.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.workout.domain.Workout;

public interface WorkoutRepository extends CrudRepository<Workout, Long> {

	List<Workout> findBydate(String date);
	
	

}