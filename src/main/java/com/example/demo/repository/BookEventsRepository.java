package com.example.demo.repository;



import com.example.demo.model.BookEvents;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookEventsRepository extends JpaRepository<BookEvents, Long> {
}
