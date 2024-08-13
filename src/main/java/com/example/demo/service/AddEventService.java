package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.AddEvent;
import com.example.demo.repository.AddEventRepository;

@Service
public class AddEventService {
    
    @Autowired
    private AddEventRepository addEventRepository;

    public List<AddEvent> getAllEvents(){
        return addEventRepository.findAll();
    }

    public AddEvent saveEvent(AddEvent event){
        return addEventRepository.save(event);
    }
    public AddEvent updateEvent(Long id, AddEvent event) {
        Optional<AddEvent> existingEvent = addEventRepository.findById(id);
        if (existingEvent.isPresent()) {
            AddEvent updatedEvent = existingEvent.get();
            updatedEvent.setAddEventTitle(event.getAddEventTitle()); // Correct method name
            updatedEvent.setAddEventUrl(event.getAddEventUrl()); // Correct method name
            return addEventRepository.save(updatedEvent);
        } else {
            throw new RuntimeException("Event not found with id: " + id);
        }
    }

    public void deleteEvent(Long id) {
        addEventRepository.deleteById(id);
    }
}
