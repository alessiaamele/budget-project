package com.qa.budgetproject.service;

import com.qa.budgetproject.domain.Days;
import com.qa.budgetproject.exceptions.DayNotFoundException;
import com.qa.budgetproject.repo.DaysRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DaysService {

    private final DaysRepository repo;

    @Autowired
    public DaysService(DaysRepository repo){
        this.repo = repo;
    }

    // View all the days created
    public List<Days> viewAllDays(){
        return this.repo.findAll();
    }

    // Create a new day
    public Days createDay(Days day){
        return this.repo.save(day);
    }

    // Find Day By Id
    public Days findDayById(Long id){
        return this.repo.findById(id).orElseThrow(DayNotFoundException::new);
    }

    // Update a day
    public Days updateNote(Long id, Days day){
        Days update = findDayById(id);
        update.setDay_of_week(day.getDay_of_week());
        update.setDay_of_week(day.getDay_of_week());
        return this.repo.save(update);
    }

    // Delete a Day
    public Boolean deleteDayById(Long id){
        if(!this.repo.existsById(id)){
            throw new DayNotFoundException();
        }
        this.repo.deleteById(id);
        return this.repo.existsById(id);
    }
}
