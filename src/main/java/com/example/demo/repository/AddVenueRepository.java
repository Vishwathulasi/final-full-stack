package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.AddVenue;

public interface AddVenueRepository extends JpaRepository<AddVenue,Long> {
    
}
