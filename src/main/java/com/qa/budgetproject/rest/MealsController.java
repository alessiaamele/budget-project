package com.qa.budgetproject.rest;

import com.qa.budgetproject.domain.Meals;
import com.qa.budgetproject.service.MealsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
public class MealsController {
    private final MealsService mealsService;

    @Autowired

    public MealsController(MealsService mealsService) {
        this.mealsService = mealsService;
    }

    @GetMapping("/getAllMeals")
    public List<Meals> getAllMeals(){
        return this.mealsService.readAllMeals();
    }

    @PostMapping("/createMeal")
    public Meals createMeal(@RequestBody Meals meal){
        return this.mealsService.createMeal(meal);
    }

    @DeleteMapping("/deleteMeal/{id}")
    public Boolean deleteMeal(@PathVariable Long id){
        return this.mealsService.deleteMealById(id);
    }

    @GetMapping("/getMealById/{id}")
    public Meals getMealById(@PathVariable Long id){
        return this.mealsService.findMealById(id);
    }

    @PutMapping("/updateMeal/{id}")
    public Meals updateMeals(@PathVariable Long id, @RequestBody Meals meal){
        return this.mealsService.updateMeal(id, meal);
    }

    @PutMapping("/updateMeal2")
    public Meals updateMealWithParam(@PathParam("id") Long id, @RequestBody Meals meal){
        return this.mealsService.updateMeal(id, meal);
    }
}
