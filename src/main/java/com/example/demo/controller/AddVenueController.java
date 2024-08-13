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

import com.example.demo.model.AddVenue;
import com.example.demo.service.AddVenueService;

@RestController
@RequestMapping("/api/addvenues")
public class AddVenueController {

    @Autowired
    private AddVenueService addVenueService;

    @GetMapping
    public List<AddVenue> getAllVenue(){
        return addVenueService.getAllVenue();
    }

    @PostMapping
    public AddVenue saveVenue(@RequestBody AddVenue venue){
        return addVenueService.saveVenue(venue);
    }

    @PutMapping("/{id}")
    public AddVenue updateVenue(@PathVariable Long id, @RequestBody AddVenue venue) {
        return addVenueService.updateVenue(id, venue);
    }

    @DeleteMapping("/{id}")
    public void deleteVenue(@PathVariable Long id) {
        addVenueService.deleteVenue(id);
    }
    
}
