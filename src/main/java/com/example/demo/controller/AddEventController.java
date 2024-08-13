package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.AddEvent;
import com.example.demo.service.AddEventService;

@RestController
@RequestMapping("/api/addevents")
public class AddEventController {

    @Autowired
    private AddEventService addEventService;

    @GetMapping
    public List<AddEvent> getAllEvents(){
        return addEventService.getAllEvents();
    }

    @PostMapping
    public AddEvent saveEvent(@RequestBody AddEvent event){
        return addEventService.saveEvent(event);
        
    }
    

    @PutMapping("/{id}")
    public AddEvent updateEvent(@PathVariable Long id, @RequestBody AddEvent event) {
        return addEventService.updateEvent(id, event);
    }

    @DeleteMapping("/{id}")
    public void deleteEvent(@PathVariable Long id) {
        addEventService.deleteEvent(id);
    }
}
