package com.qa.budgetproject.rest;

import com.qa.budgetproject.DTOs.DaysDTO;
import com.qa.budgetproject.domain.Days;
import com.qa.budgetproject.service.DaysService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @GetMapping("/getAllDays")
    public ResponseEntity<List<DaysDTO>> getAllNoteBooks(){
        return ResponseEntity.ok(this.daysService.readAllDays());
    }

    @PostMapping("/createDay")
    public ResponseEntity<DaysDTO> createDay(@RequestBody Days day){
        return new ResponseEntity<>(this.daysService.createDay(day), HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteDay/{id}")
    public Boolean deleteDay(@PathVariable Long id){
        return this.daysService.deleteDayById(id);
    }

    @GetMapping("/getDayById/{id}")
    public ResponseEntity<DaysDTO> getDayById(@PathVariable Long id){
        return ResponseEntity.ok(this.daysService.findDayById(id));
    }

    @PutMapping("/updateDay/{id}")
    public ResponseEntity<DaysDTO> updateDay(@PathVariable Long id, @RequestBody Days day){
        return ResponseEntity.ok(this.daysService.updateDay(id, day));
    }

}
