package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.AddVenue;
import com.example.demo.repository.AddVenueRepository;

@Service
public class AddVenueService {
    
    @Autowired
    private AddVenueRepository addVenueRepository;

    public List<AddVenue> getAllVenue(){
        return addVenueRepository.findAll();
    }

    public AddVenue saveVenue(AddVenue venue){
        return addVenueRepository.save(venue);
    }


    public AddVenue updateVenue(Long id, AddVenue venue) {
        Optional<AddVenue> existingVenue = addVenueRepository.findById(id);
        if (existingVenue.isPresent()) {
            AddVenue updatedVenue = existingVenue.get();
            updatedVenue.setAddVenueTitle(venue.getAddVenueTitle()); // Correct method name
            updatedVenue.setAddVenueUrl(venue.getAddVenueUrl()); // Correct method name
            return addVenueRepository.save(updatedVenue);
        } else {
            throw new RuntimeException("Venue not found with id: " + id);
        }
    }

    public void deleteVenue(Long id) {
        addVenueRepository.deleteById(id);
    }
}
