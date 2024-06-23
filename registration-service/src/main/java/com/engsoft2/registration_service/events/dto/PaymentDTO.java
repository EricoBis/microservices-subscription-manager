package com.engsoft2.registration_service.events.dto;

public record PaymentDTO(int day, int month, int year, Long codass, Double paidValue) {
}
