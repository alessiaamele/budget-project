package com.qa.budgetproject.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Days {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String day_of_week;

    @OneToMany(mappedBy = "day", fetch = FetchType.LAZY)
    private List<Meals> meal = new ArrayList<>();


    public Days(){

    }

    public Days(String day_of_week) {
        this.day_of_week = day_of_week;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDay_of_week() {
        return day_of_week;
    }

    public void setDay_of_week(String day_of_week) {
        this.day_of_week = day_of_week;
    }

    public List<Meals> getMeal() {
        return meal;
    }

    public void setMeal(List<Meals> meal) {
        this.meal = meal;
    }

}

