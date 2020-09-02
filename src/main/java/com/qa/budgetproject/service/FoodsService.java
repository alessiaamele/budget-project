package com.qa.budgetproject.service;

import com.qa.budgetproject.domain.Days;
import com.qa.budgetproject.domain.Foods;
import com.qa.budgetproject.exceptions.DayNotFoundException;
import com.qa.budgetproject.exceptions.FoodNotFoundException;
import com.qa.budgetproject.repo.DaysRepository;
import com.qa.budgetproject.repo.FoodsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodsService {
    private final FoodsRepository repo;

    @Autowired
    public FoodsService(FoodsRepository repo){
        this.repo = repo;
    }

    // View all the Foods created
    public List<Foods> readAllFoods(){
        return this.repo.findAll();
    }

    // Create a new Food
    public Foods createFood(Foods food){
        return this.repo.save(food);
    }

    // Find Food By Id
    public Foods findFoodById(Long id){
        return this.repo.findById(id).orElseThrow(FoodNotFoundException::new);
    }

    // Update a food
    public Foods updateFood(Long id, Foods food){
        Foods update = findFoodById(id);
        update.setName(food.getName());
        update.setCost(food.getCost());
        return this.repo.save(update);
    }

    // Delete a Food
    public Boolean deleteFoodById(Long id){
        if(!this.repo.existsById(id)){
            throw new DayNotFoundException();
        }
        this.repo.deleteById(id);
        return this.repo.existsById(id);
    }
}
