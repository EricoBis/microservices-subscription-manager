package com.engsof2.payment_service.adapters.controllers;

import com.engsof2.payment_service.application.dto.PaymentDTO;
import com.engsof2.payment_service.domain.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {

    private final PaymentService paymentService;

    @Autowired
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }


    @PostMapping("/registrarpagamento")
    public void registerPayment(@RequestBody PaymentDTO paymentDTO) {
        paymentService.registerPayment(paymentDTO);
    }

}
