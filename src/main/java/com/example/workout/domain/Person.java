package com.example.workout.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
//Entity for the personal information that varies
//Containing variables for it
public class Person {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long person_id;
	
	private String weight, sleep, goals;
	public Person() {}

	public Person(String weight, String sleep, String goals ) {
		super();
		this.weight = weight;
		this.sleep = sleep;
		this.goals = goals;
	}

	public Long getPerson_id() {
		return person_id;
	}

	public void setPersonid(Long person_id) {
		this.person_id = person_id;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getSleep() {
		return sleep;
	}

	public void setSleep(String sleep) {
		this.sleep = sleep;
	}

	public String getGoals() {
		return goals;
	}

	public void setGoals(String goals) {
		this.goals = goals;
	}

	@Override
	public String toString() {
		return "Person [person_id=" + person_id + ", weight=" + weight + ", sleep=" + sleep + ", goals=" + goals + "]";
	}
	
	

}
