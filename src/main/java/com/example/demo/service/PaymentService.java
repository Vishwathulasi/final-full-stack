package com.example.demo.service;


import com.example.demo.model.Payment;
import com.example.demo.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    public Payment savePayment(Payment payment) {
        payment.setPaymentDate(LocalDate.now());
        return paymentRepository.save(payment);
    }
    public List<Payment> findAllPayments() {
        return paymentRepository.findAll();
    }
}
