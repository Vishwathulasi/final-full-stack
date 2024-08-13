package com.example.demo.service;

import com.example.demo.model.BookEvents;
import com.example.demo.repository.BookEventsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookEventsService {

    @Autowired
    private BookEventsRepository bookEventsRepository;

    public List<BookEvents> getAllEvents() {
        return bookEventsRepository.findAll();
    }

    public Optional<BookEvents> getEventById(Long id) {
        return bookEventsRepository.findById(id);
    }

    public BookEvents saveEvent(BookEvents bookEvent) {
        return bookEventsRepository.save(bookEvent);
    }

    public void deleteEvent(Long id) {
        bookEventsRepository.deleteById(id);
    }
}
