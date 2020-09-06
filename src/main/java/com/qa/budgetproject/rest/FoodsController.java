package com.qa.budgetproject.rest;

import com.qa.budgetproject.DTOs.FoodsDTO;
import com.qa.budgetproject.domain.Days;
import com.qa.budgetproject.domain.Foods;
import com.qa.budgetproject.service.DaysService;
import com.qa.budgetproject.service.FoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<FoodsDTO>> getAllFoods(){
        return ResponseEntity.ok(this.foodsService.readAllFoods());
    }

//
    @PostMapping("/createFood")
    public ResponseEntity<FoodsDTO> createFood(@RequestBody Foods food){
        return new ResponseEntity<>(this.foodsService.createFood(food), HttpStatus.CREATED);
    }

    //
    @DeleteMapping("/deleteFood/{id}")
    public ResponseEntity<?> deleteFood(@PathVariable Long id){
        return this.foodsService.deleteFoodById(id)
                ? ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build()
                : ResponseEntity.noContent().build();
    }

    @GetMapping("/getFoodById/{id}")
    public ResponseEntity<FoodsDTO> getNoteById(@PathVariable Long id){
        return ResponseEntity.ok(this.foodsService.findFoodById(id));

    }

    @PutMapping("/updateFood/{id}")
    public ResponseEntity<FoodsDTO> updateFoods(@PathVariable Long id, @RequestBody Foods food){
        return ResponseEntity.ok(this.foodsService.updateFood(id, food));
    }

    @PutMapping("/updateFoodWithPathParam")
    public ResponseEntity<FoodsDTO> updateNoteWithPathParam(@PathParam("id") Long id, @RequestBody Foods food){
        // localhost:8080/updateNoteWithPathParam?id=1
        return ResponseEntity.ok(this.foodsService.updateFood(id, food));
    }




}
