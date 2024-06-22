package com.engsoft2.registration_service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.engsoft2.registration_service.entities.Subscription;
import com.engsoft2.registration_service.entities.Client;
import com.engsoft2.registration_service.entities.Application;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {
    List<Subscription> findByEndSubscriptionAfter(Date date);
    List<Subscription> findByEndSubscriptionBefore(Date date);
    List<Subscription> findByClient(Client client);
    List<Subscription> findByApplication(Application application);
}
