package com.example.workout.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.workout.domain.Difficulty;

public interface DifficultyRepository extends CrudRepository<Difficulty, Long> {

    List<Difficulty> findByText(String text);
    
}
