package com.engsof2.payment_service.application.dto;

import java.util.Date;

public record PaymentDTO(Date data, Long codAssinatura, double valorPago) {
}
