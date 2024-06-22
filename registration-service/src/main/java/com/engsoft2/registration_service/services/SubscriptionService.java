package com.engsoft2.registration_service.services;

import com.engsoft2.registration_service.entities.Subscription;
import com.engsoft2.registration_service.repositories.SubscriptionRepository;
import com.engsoft2.registration_service.services.dto.SubscriptionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SubscriptionService {

    private SubscriptionRepository subscriptionRepository;

    @Autowired
    public SubscriptionService(SubscriptionRepository subscriptionRepository) {
        this.subscriptionRepository = subscriptionRepository;
    }

    public List<SubscriptionDTO> getSubscriptionsByType(String type) {
        List<Subscription> subscriptions = switch (type) {
            case "ATIVAS" -> subscriptionRepository.findByEndSubscriptionAfter(new Date());
            case "CANCELADAS" -> subscriptionRepository.findByEndSubscriptionBefore(new Date());
            case "TODAS" -> subscriptionRepository.findAll();
            default -> throw new IllegalArgumentException("Tipo de assinatura inválido");
        };

        return subscriptions.stream().map(sub -> new SubscriptionDTO(sub.getSubscriptionId(), sub.getClientId().getClientId(), sub.getApplicationId().getAppId(), sub.getBeginSubscription(), sub.getEndSubscription(), sub.getStatus())).collect(Collectors.toList());
    }

    public List<SubscriptionDTO> getSubscriptionsByClientId(Long clientId) {
        return subscriptionRepository.findByClientId(clientId).stream().map(sub -> new SubscriptionDTO(sub.getSubscriptionId(), sub.getClientId().getClientId(), sub.getApplicationId().getAppId(), sub.getBeginSubscription(), sub.getEndSubscription(), sub.getStatus())).collect(Collectors.toList());
    }

    public List<SubscriptionDTO> getSubscriptionsByAppId(Long appId) {
        return subscriptionRepository.findByApplicationId(appId).stream().map(sub -> new SubscriptionDTO(sub.getSubscriptionId(), sub.getClientId().getClientId(), sub.getApplicationId().getAppId(), sub.getBeginSubscription(), sub.getEndSubscription(), sub.getStatus())).collect(Collectors.toList());
    }

    public SubscriptionDTO createSubscription(Long clientId, Long appId) {
        Subscription subscription = new Subscription();
        subscription.setClientId(clientRepository.findById(clientId).orElseThrow(() -> new IllegalArgumentException("Cliente não encontrado")));
        subscription.setApplicationId(applicationRepository.findById(appId).orElseThrow(() -> new IllegalArgumentException("Aplicativo não encontrado")));
        subscription.setBeginSubscription(new Date());
        subscription.setEndSubscription(null); // Assinatura ativa inicialmente
        subscription = subscriptionRepository.save(subscription);
        return new SubscriptionDTO(subscription.getSubscriptionId(), subscription.getClientId().getClientId(), subscription.getApplicationId().getAppId(), subscription.getBeginSubscription(), subscription.getEndSubscription(), subscription.getStatus());
    }

}
