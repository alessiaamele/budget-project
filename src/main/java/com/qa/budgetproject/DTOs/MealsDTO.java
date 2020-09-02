package com.qa.budgetproject.DTOs;

import java.util.ArrayList;
import java.util.List;

public class MealsDTO {
    private Long id;
    private String name;
    private String description;
    private List<FoodsDTO> foods = new ArrayList<>();

    public MealsDTO() {
    }

    public MealsDTO(String name, String description) {
        super();
        this.name = name;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<FoodsDTO> getFoods() {
        return foods;
    }

    public void setNotes(List<FoodsDTO> foods) {
        this.foods = foods;
    }

}
