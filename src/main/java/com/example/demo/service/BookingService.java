package com.example.demo.service;



import com.example.demo.model.Booking;
import com.example.demo.repository.BookingRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    public Booking createBooking(Booking booking) {
        // Add any business logic here (e.g., validations)
        return bookingRepository.save(booking);
    }
    public List<Booking> getBookingsByUserId(String userId) {
        return bookingRepository.findByUserId(userId);
    }
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }
    public void deleteBooking(Long bookingId) {
        bookingRepository.deleteById(bookingId);
    }
}
