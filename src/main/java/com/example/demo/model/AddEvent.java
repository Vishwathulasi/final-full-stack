package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class AddEvent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long addEventId;

    private String addEventTitle;
    private String addEventUrl;
    
    public Long getAddEventId() {
        return addEventId;
    }
    public void setAddEventId(Long addEventId) {
        this.addEventId = addEventId;
    }
    public String getAddEventTitle() {
        return addEventTitle;
    }
    public void setAddEventTitle(String addEventTitle) {
        this.addEventTitle = addEventTitle;
    }
    public String getAddEventUrl() {
        return addEventUrl;
    }
    public void setAddEventUrl(String addEventUrl) {
        this.addEventUrl = addEventUrl;
    }
    public AddEvent() {
    }
    public AddEvent(Long addEventId, String addEventTitle, String addEventUrl) {
        this.addEventId = addEventId;
        this.addEventTitle = addEventTitle;
        this.addEventUrl = addEventUrl;
    }

    
}
