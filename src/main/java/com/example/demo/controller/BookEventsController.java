package com.example.demo.controller;


import com.example.demo.model.BookEvents;
import com.example.demo.service.BookEventsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/events")
public class BookEventsController {

    @Autowired
    private BookEventsService bookEventsService;

    @GetMapping
    public List<BookEvents> getAllEvents() {
        return bookEventsService.getAllEvents();
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookEvents> getEventById(@PathVariable Long id) {
        Optional<BookEvents> event = bookEventsService.getEventById(id);
        return event.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public BookEvents createEvent(@RequestBody BookEvents bookEvent) {
        return bookEventsService.saveEvent(bookEvent);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookEvents> updateEvent(@PathVariable Long id, @RequestBody BookEvents bookEvent) {
        if (!bookEventsService.getEventById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        bookEvent.setId(id);
        return ResponseEntity.ok(bookEventsService.saveEvent(bookEvent));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEvent(@PathVariable Long id) {
        if (!bookEventsService.getEventById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        bookEventsService.deleteEvent(id);
        return ResponseEntity.noContent().build();
    }
}
