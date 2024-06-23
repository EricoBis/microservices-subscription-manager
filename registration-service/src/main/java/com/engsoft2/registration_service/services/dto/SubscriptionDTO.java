package com.engsoft2.registration_service.services.dto;

import com.engsoft2.registration_service.entities.SubscriptionStatus;

import java.util.Date;

public record SubscriptionDTO(Long subscriptionId, Long clientId, Long appId, Date beginSubscription, Date endSubscription, SubscriptionStatus status) {
}
