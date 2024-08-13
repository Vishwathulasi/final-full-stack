package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class AddVenue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long addVenueId;

    private String addVenueTitle;
    private String addVenueUrl;
    public Long getAddVenueId() {
        return addVenueId;
    }
    public void setAddVenueId(Long addVenueId) {
        this.addVenueId = addVenueId;
    }
    public String getAddVenueTitle() {
        return addVenueTitle;
    }
    public void setAddVenueTitle(String addVenueTitle) {
        this.addVenueTitle = addVenueTitle;
    }
    public String getAddVenueUrl() {
        return addVenueUrl;
    }
    public void setAddVenueUrl(String addVenueUrl) {
        this.addVenueUrl = addVenueUrl;
    }
    public AddVenue() {
    }
    public AddVenue(Long addVenueId, String addVenueTitle, String addVenueUrl) {
        this.addVenueId = addVenueId;
        this.addVenueTitle = addVenueTitle;
        this.addVenueUrl = addVenueUrl;
    }
    
}
