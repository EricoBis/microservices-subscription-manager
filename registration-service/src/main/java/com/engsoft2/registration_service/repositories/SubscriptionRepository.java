package com.engsoft2.registration_service.repositories;

import com.engsoft2.registration_service.entities.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {
    List<Subscription> findByEndSubscriptionAfter(Date date);
    List<Subscription> findByEndSubscriptionBefore(Date date);
    List<Subscription> findByClientId(Long clientId);
    List<Subscription> findByApplicationId(Long appId);
}