package com.example.demo.controller;

import com.example.demo.model.Cuisine;
import com.example.demo.service.CuisineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cuisines")
public class CuisineController {

    @Autowired
    private CuisineService cuisineService;

    @GetMapping
    public List<Cuisine> getAllCuisines() {
        return cuisineService.getAllCuisines();
    }

    @GetMapping("/{id}")
    public Optional<Cuisine> getCuisineById(@PathVariable Long id) {
        return cuisineService.getCuisineById(id);
    }
    @PostMapping
    public ResponseEntity<Cuisine> createOrUpdateCuisine(@RequestBody Cuisine cuisine) {
        Cuisine savedCuisine = cuisineService.saveCuisine(cuisine);
        return ResponseEntity.ok(savedCuisine);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCuisineById(@PathVariable Long id) {
        cuisineService.deleteCuisineById(id);
        return ResponseEntity.noContent().build();
    }
}

