package com.example.workout.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.workout.domain.WorkoutRepository;
import com.example.workout.domain.DifficultyRepository;
import com.example.workout.domain.PersonRepository;
import com.example.workout.domain.Workout;


@Controller
public class WorkoutController {

	@Autowired
	private PersonRepository personRepo;
	
	@Autowired
	private WorkoutRepository workoutRepo;
	
	@Autowired
	private DifficultyRepository diffRepo;
	
	// "home page" shows all the workouts and personal info
	@RequestMapping(value= {"/", "/workoutlist"})
	public String Workout(Model model) {
	
		model.addAttribute("workouts", workoutRepo.findAll());
		model.addAttribute("persons", personRepo.findAll());
		return "workoutlist";
	}
	
	// Add a workout to the list
	@RequestMapping(value = "/add")
	public String addWorkout (Model model) {
		model.addAttribute("workout", new Workout());
		model.addAttribute("difficulties", diffRepo.findAll());
		return "addworkout";
	}
	// Save a workout to the list
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveWorkout (Workout workout) {
		workoutRepo.save(workout);
		return "redirect:workoutlist";
	}
	//Delete a workout from the list
	@RequestMapping(value= "/delete/{id}", method = RequestMethod.GET)
	
	public String deleteWorkout(@PathVariable("id") Long workoutId, Model model) {
		
		workoutRepo.deleteById(workoutId);
		return "redirect:../workoutlist";
}
	// Edit a exsisting workout
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String editWorkout(@PathVariable("id")Long workoutId, Model model) {
	
		model.addAttribute("workout", workoutRepo.findById(workoutId));
		model.addAttribute("difficulties", diffRepo.findAll());
		
		return "editworkout";
		
	}
	// REST for all the workouts
	@GetMapping("/workouts")
	public @ResponseBody List <Workout> workoutlistRest(){
	return (List<Workout>) workoutRepo.findAll();
		
	}
	
	// REST for a specific workout based on id
	@GetMapping("/workouts/{id}")
	public @ResponseBody Optional<Workout> findWorkoutRest(@PathVariable("id")Long id){
	return  workoutRepo.findById(id);
		
	}
	

	}
