package com.example.demo.repository;


import com.example.demo.model.Venue;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VenueRepository extends JpaRepository<Venue, Long> {
    List<Venue> findByLocation(String location);
}

