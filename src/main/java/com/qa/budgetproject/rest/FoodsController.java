package com.qa.budgetproject.rest;

import com.qa.budgetproject.domain.Days;
import com.qa.budgetproject.domain.Foods;
import com.qa.budgetproject.service.DaysService;
import com.qa.budgetproject.service.FoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
public class FoodsController {

    private final FoodsService foodsService;

    @Autowired

    public FoodsController(FoodsService foodsService) {
        this.foodsService = foodsService;
    }

    @GetMapping("/getAllFoods")
    public List<Foods> getAllFoods(){
        return this.foodsService.readAllFoods();
    }

    @PostMapping("/createFood")
    public Foods createFood(@RequestBody Foods food){
        return this.foodsService.createFood(food);
    }

    @DeleteMapping("/deleteFood/{id}")
    public Boolean deleteFood(@PathVariable Long id){
        return this.foodsService.deleteFoodById(id);
    }

    @GetMapping("/getFoodById/{id}")
    public Foods getFoodById(@PathVariable Long id){
        return this.foodsService.findFoodById(id);
    }

    @PutMapping("/updateFood/{id}")
    public Foods updateFoods(@PathVariable Long id, @RequestBody Foods food){
        return this.foodsService.updateFood(id, food);
    }

    @PutMapping("/updateFood2")
    public Foods updateFoodWithParam(@PathParam("id") Long id, @RequestBody Foods food){
        return this.foodsService.updateFood(id, food);
    }

}
