package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class BookEvents {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String eventName;
    private String eventImageUrl;
    private String eventDescription;
    private Double eventRatingValue; // Using Double to accommodate fractional values

    // Constructors
    public BookEvents() {}

    public BookEvents(String eventName, String eventImageUrl, String eventDescription, Double eventRatingValue) {
        this.eventName = eventName;
        this.eventImageUrl = eventImageUrl;
        this.eventDescription = eventDescription;
        this.eventRatingValue = eventRatingValue;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventImageUrl() {
        return eventImageUrl;
    }

    public void setEventImageUrl(String eventImageUrl) {
        this.eventImageUrl = eventImageUrl;
    }

    public String getEventDescription() {
        return eventDescription;
    }

    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }

    public Double getEventRatingValue() {
        return eventRatingValue;
    }

    public void setEventRatingValue(Double eventRatingValue) {
        this.eventRatingValue = eventRatingValue;
    }
}
