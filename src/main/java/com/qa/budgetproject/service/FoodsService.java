package com.qa.budgetproject.service;

import org.modelmapper.ModelMapper;
import com.qa.budgetproject.DTOs.FoodsDTO;
import com.qa.budgetproject.domain.Foods;
import com.qa.budgetproject.exceptions.DayNotFoundException;
import com.qa.budgetproject.exceptions.FoodNotFoundException;
import com.qa.budgetproject.repo.FoodsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FoodsService {
    private final FoodsRepository repo;

    private final ModelMapper mapper;

    @Autowired
    public FoodsService(FoodsRepository repo, ModelMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;

    }

    public FoodsDTO mapToDTO(Foods food) {
        return this.mapper.map(food, FoodsDTO.class);}

        // Create new food
    public FoodsDTO createFood(Foods food){
        return this.mapToDTO(this.repo.save(food));
    }


    // View all the Foods created
    public List<FoodsDTO> readAllFoods(){
        return this.repo.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());       }


        // Find Food By Id
        public FoodsDTO findFoodById(Long id){
            return this.mapToDTO(this.repo.findById(id).orElseThrow(FoodNotFoundException::new));    }


    // Update a food
        public FoodsDTO updateFood(Long id, Foods food){
        Foods update = this.repo.findById(id).orElseThrow(FoodNotFoundException::new);
        update.setName(food.getName());
        update.setCost(food.getCost());
        return this.mapToDTO(this.repo.save(food));
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
