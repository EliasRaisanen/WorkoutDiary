package com.example.workout.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.workout.domain.Person;
import com.example.workout.domain.PersonRepository;
import com.example.workout.domain.Workout;

@Controller
public class PersonController {
	@Autowired
	private PersonRepository personRepo;
	
	//Edit the personal info
	@RequestMapping(value = "/addperson")
	public String addWorkout (Model model) {
		model.addAttribute("person", new Person());
		
		return "editperson";
	
}	//Save the personal info
	@RequestMapping(value = "/saveperson", method = RequestMethod.POST)
	public String savePerson (Person person) {
		personRepo.save(person);
		return "redirect:workoutlist";
	}
}