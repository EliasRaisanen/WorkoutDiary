package com.example.workout;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.workout.web.PersonController;
import com.example.workout.web.WorkoutController;

import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class WorkoutApplicationTests {

	@Autowired
	private PersonController personController;
	
	@Autowired
	private WorkoutController workoutController;
	
	@Test
	public void contextLoads() {
		assertThat(personController).isNotNull();
	}
	
	@Test
	public void contextLoads2() {
		assertThat(workoutController).isNotNull();
	}


}
