package com.qa.budgetproject.domain;

import javax.persistence.*;

@Entity
public class Foods {

    @Id
    @GeneratedValue
    private Long Id;

    @Column
    private String name;

    @Column
    private Long cost;

    @ManyToOne(targetEntity = Meals.class)
    private Meals meal;

    public Foods(){

    }

    public Foods(String name, Long cost) {
        this.name = name;
        this.cost = cost;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCost() {
        return cost;
    }

    public void setCost(Long cost) {
        this.cost = cost;
    }

    public Meals getMeal() {
        return meal;
    }

    public void setMeal(Meals meal) {
        this.meal = meal;
    }

}
