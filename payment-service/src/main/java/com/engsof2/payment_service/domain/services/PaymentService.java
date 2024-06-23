package com.engsof2.payment_service.domain.services;

import com.engsof2.payment_service.adapters.repositories.impl.PaymentRepository;
import com.engsof2.payment_service.application.dto.PaymentDTO;
import com.engsof2.payment_service.domain.entities.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    private final PaymentRepository paymentRepository;

    @Autowired
    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public void registerPayment(PaymentDTO paymentDTO) {
        var payment = Payment.builder()
                .codAssinatura(paymentDTO.codAssinatura())
                .valorPago(paymentDTO.valorPago())
                .dataPagamento(paymentDTO.data())
                .build();
        paymentRepository.save(payment);
    }
}
