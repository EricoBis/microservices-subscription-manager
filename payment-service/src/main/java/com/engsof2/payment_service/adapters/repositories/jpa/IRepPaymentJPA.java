package com.engsof2.payment_service.adapters.repositories.jpa;

import com.engsof2.payment_service.domain.entities.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRepPaymentJPA extends JpaRepository<Payment, Long> {
}
