package com.qa.budgetproject.rest;

import com.qa.budgetproject.DTOs.MealsDTO;
import com.qa.budgetproject.domain.Meals;
import com.qa.budgetproject.service.MealsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<MealsDTO>> getAllMeals(){
        return ResponseEntity.ok(this.mealsService.readAllMeals());
    }

    @PostMapping("/createMeal")
    public ResponseEntity<MealsDTO> createMeal(@RequestBody Meals meal){
        return new ResponseEntity<>(this.mealsService.createMeal(meal), HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteMeal/{id}")
    public Boolean deleteMeal(@PathVariable Long id){
        return this.mealsService.deleteMealById(id);
    }

    @GetMapping("/getMealById/{id}")
    public ResponseEntity<MealsDTO> getMealById(@PathVariable Long id){
        return ResponseEntity.ok(this.mealsService.findMealById(id));
    }

    @PutMapping("/updateMeal/{id}")
    public ResponseEntity<MealsDTO> updateNoteBook(@PathVariable Long id, @RequestBody Meals meal){
        return ResponseEntity.ok(this.mealsService.updateMeal(id, meal));
    }


}
