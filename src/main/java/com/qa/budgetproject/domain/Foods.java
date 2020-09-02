package com.qa.budgetproject.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Foods {

    @Id
    @GeneratedValue
    private Long Id;

    @Column
    private String name;

    @Column
    private Long cost;

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
}
