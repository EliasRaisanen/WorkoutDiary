package com.example.workout.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
//Entity for the workouts that the user does
//Containing the variables for the workout table
public class Workout {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private String description, date, place, length;
	 @ManyToOne

	    @JoinColumn(name = "difficulty_id")
	    
	    private Difficulty difficulty;
	 public Workout() {}

	public Workout(String description, String date, String place, String length, Difficulty difficulty) {
		super();
		this.description = description;
		this.date = date;
		this.place = place;
		this.length = length;
		this.difficulty = difficulty;
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getLength() {
		return length;
	}

	public void setLength(String length) {
		this.length = length;
	}
	

	public Difficulty getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(Difficulty difficulty) {
		this.difficulty = difficulty;
	}

	@Override
	public String toString() {
		
		if(this.difficulty != null)
			
			return "Workout [id=" + id + ", description=" + description + ", date=" + date + ", place=" + place + ", length="
					+ length + ", difficulty=" + this.getDifficulty() + "]";
		
		return "Workout [id=" + id + ", description=" + description + ", date=" + date + ", place=" + place
				+ ", length=" + length + "]";
	}
	
}
