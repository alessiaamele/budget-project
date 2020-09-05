package com.qa.budgetproject.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "foods"})
public class Meals {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String name;

    // check how to make it nullable
    @Column
    private String description;

    @OneToMany(mappedBy = "meal", fetch = FetchType.EAGER)
    private List<Foods> food = new ArrayList<>();

    @ManyToOne(targetEntity = Days.class)
    private Days day;


    public Meals(){

    }

    public Days getDay() {
        return day;
    }

    public void setDay(Days day) {
        this.day = day;
    }
    public Meals(String name, String description) {
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

    public List<Foods> getFoods() {
        return food;
    }

    public void setFoods(List<Foods> food) {
        this.food = food;
    }

}
