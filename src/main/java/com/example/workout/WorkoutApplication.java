package com.example.workout;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


import com.example.workout.domain.Difficulty;
import com.example.workout.domain.DifficultyRepository;
import com.example.workout.domain.Person;
import com.example.workout.domain.PersonRepository;
import com.example.workout.domain.Workout;
import com.example.workout.domain.WorkoutRepository;

@SpringBootApplication
public class WorkoutApplication {
	private static final Logger log = LoggerFactory.getLogger(WorkoutApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(WorkoutApplication.class, args);
	}

	
	@Bean
	public CommandLineRunner diary(WorkoutRepository wrepository, PersonRepository prepository, DifficultyRepository drepository) {
	return (args) -> {
		 
		//Options for the dropdown chooser
		drepository.save(new Difficulty("A walk in the park"));
		drepository.save(new Difficulty("Easy"));
		drepository.save(new Difficulty("Medium"));
		drepository.save(new Difficulty("Hard"));
		drepository.save(new Difficulty("Almost died"));
		
		//Test data for the actual workouts that the user lists and edits
		wrepository.save(new Workout("Salitreeni", "lähisali", "11.10", "60 min",drepository.findByText("Easy").get(0)));
		
		// Personal data that varies everyday
		prepository.save(new Person("-", "-", "-"));
		
		
		for (Workout workout : wrepository.findAll()) {
			log.info(workout.toString());
		}
		
		for (Person person : prepository.findAll()) {
			log.info(person.toString());
		}
	};
	}
}
