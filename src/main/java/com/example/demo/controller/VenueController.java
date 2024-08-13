package com.example.demo.controller;


import com.example.demo.model.Venue;
import com.example.demo.service.VenueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/venues")
public class VenueController {
    @Autowired
    private VenueService venueService;

    @GetMapping
    public List<Venue> getAllVenues() {
        return venueService.getAllVenues();
    }

    @GetMapping("/{id}")
    public Venue getVenueById(@PathVariable Long id) {
        return venueService.getVenueById(id);
    }

    @GetMapping("/location/{location}")
    public List<Venue> getVenuesByLocation(@PathVariable String location) {
        return venueService.getVenuesByLocation(location);
    }

    @PostMapping
    public Venue createVenue(@RequestBody Venue venue) {
        return venueService.saveVenue(venue);
    }

    @DeleteMapping("/{id}")
    public void deleteVenue(@PathVariable Long id) {
        venueService.deleteVenue(id);
    }
}
