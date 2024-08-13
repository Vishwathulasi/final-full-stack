package com.example.demo.model;



import java.util.List;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Venue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private int capacity;
    private int parkingCapacity;
    private double price;
    private String location;
    private String imageUrl;

    @ElementCollection
    private List<String> bookedDates;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getParkingCapacity() {
        return parkingCapacity;
    }

    public void setParkingCapacity(int parkingCapacity) {
        this.parkingCapacity = parkingCapacity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public List<String> getBookedDates() {
        return bookedDates;
    }

    public void setBookedDates(List<String> bookedDates) {
        this.bookedDates = bookedDates;
    }

    public Venue() {
    }

    public Venue(Long id, String name, String description, int capacity, int parkingCapacity, double price,
            String location, String imageUrl, List<String> bookedDates) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.capacity = capacity;
        this.parkingCapacity = parkingCapacity;
        this.price = price;
        this.location = location;
        this.imageUrl = imageUrl;
        this.bookedDates = bookedDates;
    }

    
}
