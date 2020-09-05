package com.qa.budgetproject.service;

import com.qa.budgetproject.DTOs.MealsDTO;
import com.qa.budgetproject.domain.Meals;
import com.qa.budgetproject.exceptions.DayNotFoundException;
import com.qa.budgetproject.exceptions.MealNotFoundException;
import com.qa.budgetproject.repo.MealsRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MealsService {

    private final MealsRepository repo;

    private final ModelMapper mapper;

    @Autowired
    public MealsService(MealsRepository repo, ModelMapper mapper){
        this.repo = repo;
        this.mapper = mapper;
    }

    private MealsDTO mapToDTO(Meals meal){
        return this.mapper.map(meal, MealsDTO.class);
    }


    // View all the meals created
    public List<MealsDTO> readAllMeals(){
        return this.repo.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    // Create a new meal
    public MealsDTO createMeal(Meals meal){
        return this.mapToDTO(this.repo.save(meal));
    }

    // Find meal By Id
    public MealsDTO findMealById(Long id){
        return this.mapToDTO(this.repo.findById(id).orElseThrow(MealNotFoundException::new));
    }

    // Update a meal
    public MealsDTO updateMeal(Long id, Meals meal){
        Meals update = this.repo.findById(id).orElseThrow(MealNotFoundException::new);
        update.setName(meal.getName());
        update.setDescription(meal.getDescription());
        return this.mapToDTO(this.repo.save(update));
    }


    // Delete a Meal
    public Boolean deleteMealById(Long id){
        if(!this.repo.existsById(id)){
            throw new MealNotFoundException();
        }
        this.repo.deleteById(id);
        return this.repo.existsById(id);
    }

}
