package com.engsof2.payment_service.domain.services;

import com.engsof2.payment_service.adapters.messaging.PaymentProducer;
import com.engsof2.payment_service.adapters.repositories.impl.PaymentRepository;
import com.engsof2.payment_service.application.dto.PaymentDTO;
import com.engsof2.payment_service.domain.entities.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;

@Service
public class PaymentService {

    private final PaymentRepository paymentRepository;
    private final PaymentProducer paymentProducer;

    @Autowired
    public PaymentService(PaymentRepository paymentRepository, PaymentProducer paymentProducer) {
        this.paymentRepository = paymentRepository;
        this.paymentProducer = paymentProducer;
    }

    public void registerPayment(PaymentDTO paymentDTO) {
        var payment = Payment.builder()
                .codAssinatura(paymentDTO.codass())
                .valorPago(paymentDTO.paidValue())
                .dataPagamento(new Date(paymentDTO.year() - 1900, paymentDTO.month() - 1, paymentDTO.day()))
                .build();
        paymentRepository.save(payment);
        paymentProducer.sendPaymentMessage(paymentDTO);
    }
}
