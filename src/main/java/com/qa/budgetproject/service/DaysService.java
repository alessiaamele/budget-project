package com.qa.budgetproject.service;

import com.qa.budgetproject.DTOs.DaysDTO;
import com.qa.budgetproject.domain.Days;
import com.qa.budgetproject.exceptions.DayNotFoundException;
import com.qa.budgetproject.repo.DaysRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DaysService {

    private final DaysRepository repo;

    private final ModelMapper mapper;

    @Autowired
    public DaysService(DaysRepository repo, ModelMapper mapper){
        this.repo = repo;
        this.mapper = mapper;

    }


    private DaysDTO mapToDTO(Days day){
        return this.mapper.map(day, DaysDTO.class);
    }

    // View all the days created
    public List<DaysDTO> readAllDays(){
        return this.repo.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    // Create a new day
    public DaysDTO createDay(Days day){
        return this.mapToDTO(this.repo.save(day));
    }

    // Find Day By Id
    public DaysDTO findDayById(Long id){
        return this.mapToDTO(this.repo.findById(id).orElseThrow(DayNotFoundException::new));
    }

    // Update a day
    public DaysDTO updateDay(Long id, Days day){
        Days update = this.repo.findById(id).orElseThrow(DayNotFoundException::new);
        update.setDay_of_week(day.getDay_of_week());
        return this.mapToDTO(this.repo.save(update));
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
