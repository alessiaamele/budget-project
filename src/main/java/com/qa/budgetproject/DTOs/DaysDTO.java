package com.qa.budgetproject.DTOs;

public class DaysDTO {
    private Long id;
    private String day_of_week;

    public DaysDTO() {
    }

    public DaysDTO(String day_of_week) {
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

}
