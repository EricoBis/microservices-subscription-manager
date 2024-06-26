package com.engsoft2.registration_service.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.engsoft2.registration_service.entities.Subscription;
import com.engsoft2.registration_service.entities.Client;
import com.engsoft2.registration_service.entities.Application;
import com.engsoft2.registration_service.repositories.SubscriptionRepository;
import com.engsoft2.registration_service.repositories.ClientRepository;
import com.engsoft2.registration_service.repositories.ApplicationRepository;
import com.engsoft2.registration_service.services.dto.SubscriptionDTO;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class SubscriptionService {

    private final SubscriptionRepository subscriptionRepository;
    private final ClientRepository clientRepository;
    private final ApplicationRepository applicationRepository;

    @Autowired
    public SubscriptionService(SubscriptionRepository subscriptionRepository, ClientRepository clientRepository, ApplicationRepository applicationRepository) {
        this.subscriptionRepository = subscriptionRepository;
        this.clientRepository = clientRepository;
        this.applicationRepository = applicationRepository;
    }

    /**
     * Get Subscriptions in database by Status
     * @param type Status type {"TODAS, "ATIVOS", "CANCELADAS"}
     * @return Return a list of subscriptions filtered by type
     */
    public List<SubscriptionDTO> getSubscriptionsByType(String type) {
        List<Subscription> subscriptions = switch (type) {
			case "ATIVAS" -> subscriptionRepository.findByEndSubscriptionAfter(new Date());
			case "CANCELADAS" -> subscriptionRepository.findByEndSubscriptionBefore(new Date());
			case "TODAS" -> subscriptionRepository.findAll();
			default -> throw new IllegalArgumentException("Invalid Status Type");
		};

		return subscriptions.stream()
                .map(sub -> new SubscriptionDTO(sub.getSubscriptionId(), sub.getClient().getClientId(), sub.getApplication().getAppId(), sub.getBeginSubscription(), sub.getEndSubscription(), sub.getStatus()))
                .toList();
    }

    /**
     * Get Subscriptions in database by Client Id
     * @param clientId Client ID in DB
     * @return Return a list of subscriptions filtered by the client
     */
    public List<SubscriptionDTO> getSubscriptionsByClientId(Long clientId) {
        Client client = clientRepository.findById(clientId).orElseThrow(() -> new IllegalArgumentException("Cliente não encontrado"));
        return subscriptionRepository.findByClient(client).stream()
                .map(sub -> new SubscriptionDTO(sub.getSubscriptionId(), sub.getClient().getClientId(), sub.getApplication().getAppId(), sub.getBeginSubscription(), sub.getEndSubscription(), sub.getStatus()))
                .collect(Collectors.toList());
    }

    /**
     * Get Subscriptions in database by Application Id
     * @param appId Application ID in DB
     * @return Return a list of subscriptions filtered by the application
     */
    public List<SubscriptionDTO> getSubscriptionsByAppId(Long appId) {
        Application application = applicationRepository.findById(appId).orElseThrow(() -> new IllegalArgumentException("Aplicativo não encontrado"));
        return subscriptionRepository.findByApplication(application).stream()
                .map(sub -> new SubscriptionDTO(sub.getSubscriptionId(), sub.getClient().getClientId(), sub.getApplication().getAppId(), sub.getBeginSubscription(), sub.getEndSubscription(), sub.getStatus()))
                .collect(Collectors.toList());
    }

    /**
     * Create a subscription of the app to the client for 7 days
     * @param clientId Client Id
     * @param appId Application Id
     * @return Returns the subscription
     */
    public SubscriptionDTO createSubscription(Long clientId, Long appId) {
        Calendar beginSubscription = Calendar.getInstance();
        Calendar endSubscription = Calendar.getInstance();

        endSubscription.add(Calendar.DAY_OF_MONTH, 7);

        Subscription subscription = new Subscription(
                applicationRepository.findById(appId).orElseThrow(() -> new IllegalArgumentException("Aplicativo não encontrado")),
                clientRepository.findById(clientId).orElseThrow(() -> new IllegalArgumentException("Cliente não encontrado")),
                beginSubscription.getTime(),
                endSubscription.getTime()
        );

        subscription = subscriptionRepository.save(subscription);

        return new SubscriptionDTO(subscription.getSubscriptionId(), subscription.getClient().getClientId(), subscription.getApplication().getAppId(), beginSubscription.getTime(), subscription.getEndSubscription(), subscription.getStatus());
    }

    public SubscriptionDTO getSubscription(Long subscriptionId) {
        Optional<Subscription> subscription = subscriptionRepository.findById(subscriptionId);

        if (subscription.isEmpty())
            throw new IllegalArgumentException("Invalid Subscription ID");

        Subscription sub = subscription.get();

        return new SubscriptionDTO(sub.getSubscriptionId(), sub.getClient().getClientId(), sub.getApplication().getAppId(), sub.getBeginSubscription(), sub.getEndSubscription(), sub.getStatus());
    }
}

