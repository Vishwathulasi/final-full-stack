package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Cuisine {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cuisineName;
    private String cuisineUrl;
    private String cuisineDescription;
    private double cuisinePrice;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCuisineName() {
        return cuisineName;
    }

    public void setCuisineName(String cuisineName) {
        this.cuisineName = cuisineName;
    }

    public String getCuisineUrl() {
        return cuisineUrl;
    }

    public void setCuisineUrl(String cuisineUrl) {
        this.cuisineUrl = cuisineUrl;
    }

    public String getCuisineDescription() {
        return cuisineDescription;
    }

    public void setCuisineDescription(String cuisineDescription) {
        this.cuisineDescription = cuisineDescription;
    }

    public double getCuisinePrice() {
        return cuisinePrice;
    }

    public void setCuisinePrice(double cuisinePrice) {
        this.cuisinePrice = cuisinePrice;
    }

    public Cuisine() {
    }

    public Cuisine(Long id, String cuisineName, String cuisineUrl, String cuisineDescription, double cuisinePrice) {
        this.id = id;
        this.cuisineName = cuisineName;
        this.cuisineUrl = cuisineUrl;
        this.cuisineDescription = cuisineDescription;
        this.cuisinePrice = cuisinePrice;
    }
    
}
