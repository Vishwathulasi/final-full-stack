package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.AddEvent;

public interface AddEventRepository extends JpaRepository<AddEvent, Long>{
    
}
