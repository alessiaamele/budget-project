package com.qa.budgetproject.service;

import com.qa.budgetproject.domain.Meals;
import com.qa.budgetproject.exceptions.DayNotFoundException;
import com.qa.budgetproject.exceptions.MealNotFoundException;
import com.qa.budgetproject.repo.MealsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MealsService {

    private final MealsRepository repo;

    @Autowired
    public MealsService(MealsRepository repo){
        this.repo = repo;
    }

    // View all the meals created
    public List<Meals> readAllMeals(){
        return this.repo.findAll();
    }

    // Create a new meal
    public Meals createMeal(Meals meal){
        return this.repo.save(meal);
    }

    // Find meal By Id
    public Meals findMealById(Long id){
        return this.repo.findById(id).orElseThrow(MealNotFoundException::new);
    }

    // Update a meal
    public Meals updateMeal(Long id, Meals meal){
        Meals update = findMealById(id);
        update.setName(meal.getName());
        update.setDescription(meal.getDescription());
        return this.repo.save(update);
    }

    // Delete a Meal
    public Boolean deleteMealById(Long id){
        if(!this.repo.existsById(id)){
            throw new DayNotFoundException();
        }
        this.repo.deleteById(id);
        return this.repo.existsById(id);
    }
}
