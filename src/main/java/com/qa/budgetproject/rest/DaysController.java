package com.qa.budgetproject.rest;

import com.qa.budgetproject.domain.Days;
import com.qa.budgetproject.service.DaysService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
public class DaysController {

    private final DaysService daysService;

    @Autowired

    public DaysController(DaysService daysService) {
        this.daysService = daysService;
    }

    @GetMapping("/")
    public List<Days> getAllDays(){
       return this.daysService.readAllDays();
    }

    @PostMapping("/createDay")
    public Days createDay(@RequestBody Days day){
        return this.daysService.createDay(day);
    }

    @DeleteMapping("/delete/{id}")
    public Boolean deleteDay(@PathVariable Long id){
       return this.daysService.deleteDayById(id);
    }

    @GetMapping("/getDayById/{id}")
    public Days getDayById(@PathVariable Long id){
        return this.daysService.findDayById(id);
    }

    @PutMapping("/updateDay/{id}")
    public Days updateDays(@PathVariable Long id, @RequestBody Days day){
        return this.daysService.updateDay(id, day);
    }

    @PutMapping("/updateDay2")
    public Days updateDayWithParam(@PathParam("id") Long id, @RequestBody Days day){
        return this.daysService.updateDay(id, day);
    }
}
