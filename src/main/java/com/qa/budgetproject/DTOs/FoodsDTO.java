package com.qa.budgetproject.DTOs;

public class FoodsDTO {
    private Long id;
    private String name;
    private Long cost;

    public FoodsDTO() {
    }

    public FoodsDTO(String name, Long cost) {
        this.name = name;
        this.cost = cost;
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

    public Long getCost() {
        return cost;
    }

    public void setCost(Long cost) {
        this.cost = cost;
    }

}
