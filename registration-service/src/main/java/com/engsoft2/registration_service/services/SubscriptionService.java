package com.engsoft2.registration_service.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.engsoft2.registration_service.entities.Subscription;
import com.engsoft2.registration_service.entities.Client;
import com.engsoft2.registration_service.entities.Application;
import com.engsoft2.registration_service.repositories.SubscriptionRepository;
import com.engsoft2.registration_service.repositories.ClientRepository;
import com.engsoft2.registration_service.repositories.ApplicationRepository;
import com.engsoft2.registration_service.dtos.SubscriptionDTO;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class SubscriptionService {

    @Autowired
    private SubscriptionRepository subscriptionRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ApplicationRepository applicationRepository;

    public SubscriptionService(SubscriptionRepository subscriptionRepository, ClientRepository clientRepository, ApplicationRepository applicationRepository) {
        this.subscriptionRepository = subscriptionRepository;
        this.clientRepository = clientRepository;
        this.applicationRepository = applicationRepository;
    }

    public List<SubscriptionDTO> getSubscriptionsByType(String type) {
        List<Subscription> subscriptions;
        switch (type) {
            case "ATIVAS":
                subscriptions = subscriptionRepository.findByEndSubscriptionAfter(new Date());
                break;
            case "CANCELADAS":
                subscriptions = subscriptionRepository.findByEndSubscriptionBefore(new Date());
                break;
            case "TODAS":
                subscriptions = subscriptionRepository.findAll();
                break;
            default:
                throw new IllegalArgumentException("Tipo de assinatura inválido");
        }

        return subscriptions.stream()
                .map(sub -> new SubscriptionDTO(sub.getSubscriptionId(), sub.getClient().getClientId(), sub.getApplication().getAppId(), sub.getBeginSubscription(), sub.getEndSubscription(), sub.getStatus()))
                .collect(Collectors.toList());
    }

    public List<SubscriptionDTO> getSubscriptionsByClientId(Long clientId) {
        Client client = clientRepository.findById(clientId).orElseThrow(() -> new IllegalArgumentException("Cliente não encontrado"));
        return subscriptionRepository.findByClient(client).stream()
                .map(sub -> new SubscriptionDTO(sub.getSubscriptionId(), sub.getClient().getClientId(), sub.getApplication().getAppId(), sub.getBeginSubscription(), sub.getEndSubscription(), sub.getStatus()))
                .collect(Collectors.toList());
    }

    public List<SubscriptionDTO> getSubscriptionsByAppId(Long appId) {
        Application application = applicationRepository.findById(appId).orElseThrow(() -> new IllegalArgumentException("Aplicativo não encontrado"));
        return subscriptionRepository.findByApplication(application).stream()
                .map(sub -> new SubscriptionDTO(sub.getSubscriptionId(), sub.getClient().getClientId(), sub.getApplication().getAppId(), sub.getBeginSubscription(), sub.getEndSubscription(), sub.getStatus()))
                .collect(Collectors.toList());
    }

    public SubscriptionDTO createSubscription(Long clientId, Long appId) {
        Subscription subscription = new Subscription();
        subscription.setClient(clientRepository.findById(clientId).orElseThrow(() -> new IllegalArgumentException("Cliente não encontrado")));
        subscription.setApplication(applicationRepository.findById(appId).orElseThrow(() -> new IllegalArgumentException("Aplicativo não encontrado")));
        subscription.setBeginSubscription(new Date());
        subscription.setEndSubscription(null); // Assinatura ativa inicialmente
        subscription = subscriptionRepository.save(subscription);
        return new SubscriptionDTO(subscription.getSubscriptionId(), subscription.getClient().getClientId(), subscription.getApplication().getAppId(), subscription.getBeginSubscription(), subscription.getEndSubscription(), subscription.getStatus());
    }
}

