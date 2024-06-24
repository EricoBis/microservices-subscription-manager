package com.engsof2.payment_service.adapters.repositories.impl;

import com.engsof2.payment_service.adapters.repositories.jpa.IRepPaymentJPA;
import com.engsof2.payment_service.domain.entities.Payment;
import com.engsof2.payment_service.domain.repositories.IRepPayment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PaymentRepository implements IRepPayment {

    private final IRepPaymentJPA paymentJPA;

    @Autowired
    public PaymentRepository(IRepPaymentJPA paymentJPA) {
        this.paymentJPA = paymentJPA;
    }

    @Override
    public void save(Payment payment) {
        paymentJPA.save(payment);
    }
}
