package com.engsoft2.registration_service.events;

import java.util.Date;

public class PaymentEvent {
    private Date paymentDate;
    private Long codass;
    private Double valorPago;

    // Constructor, getters, and setters
    public PaymentEvent(Date paymentDate, Long codass, Double valorPago) {
        this.paymentDate = paymentDate;
        this.codass = codass;
        this.valorPago = valorPago;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public Long getCodass() {
        return codass;
    }

    public Double getValorPago() {
        return valorPago;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public void setCodass(Long codass) {
        this.codass = codass;
    }

    public void setValorPago(Double valorPago) {
        this.valorPago = valorPago;
    }
}