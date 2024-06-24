package com.engsof2.payment_service.domain.repositories;

import com.engsof2.payment_service.domain.entities.Payment;

public interface IRepPayment {

    void save(Payment payment);
}
