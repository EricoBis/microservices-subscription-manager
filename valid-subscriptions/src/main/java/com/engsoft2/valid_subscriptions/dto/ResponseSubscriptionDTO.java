package com.engsoft2.valid_subscriptions.dto;

import java.util.Date;

public record ResponseSubscriptionDTO(Long subscriptionId, Long clientId, Long appId, Date beginSubscription, Date endSubscription, SubscriptionStatus status) {
}
