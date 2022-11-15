package com.example.workout.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
// Entity for the dropdown chooser
// Containing the variables for it
public class Difficulty {

	
	
	
	 @Id
	    @GeneratedValue(strategy=GenerationType.AUTO)
		private Long difficulty_id;
		private String text;
		 
		@OneToMany(cascade = CascadeType.ALL, mappedBy = "difficulty")
		@JsonIgnore
		private List<Workout> workouts;
		
		public Difficulty() {}
		
		public Difficulty(String text) {
			super();
			this.text = text;
		}

		public Long getDifficulty_id() {
			return difficulty_id;
		}

		public void setDifficulty_id(Long difficulty_id) {
			this.difficulty_id = difficulty_id;
		}

		public String getText() {
			return text;
		}

		public void setText(String text) {
			this.text = text;
		}

		public List<Workout> getWorkouts() {
			return workouts;
		}

		public void setWorkouts(List<Workout> workouts) {
			this.workouts = workouts;
		}

		@Override
		public String toString() {
			return "Difficulty [difficulty_id=" + difficulty_id + ", text=" + text + "]";
		}
		
		
}
