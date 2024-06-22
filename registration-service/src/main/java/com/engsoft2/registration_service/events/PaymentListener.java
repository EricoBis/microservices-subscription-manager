package com.engsoft2.registration_service.events;

import com.engsoft2.registration_service.entities.Subscription;
import com.engsoft2.registration_service.repositories.SubscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Date;

@Component
public class PaymentListener {

    private SubscriptionRepository subscriptionRepository;

    @Autowired
    public PaymentListener(SubscriptionRepository subscriptionRepository) {
        this.subscriptionRepository = subscriptionRepository;
    }

    @EventListener
    public void handlePaymentEvent(PaymentEvent paymentEvent) {
        Subscription subscription = subscriptionRepository.findById(paymentEvent.getCodass())
                .orElseThrow(() -> new IllegalArgumentException("Assinatura não encontrada"));

        // Se a assinatura não tem data de término ou a data de término é no passado, considere-a ativa
        if (subscription.getEndSubscription() == null || subscription.getEndSubscription().before(new Date())) {
            // Prorrogar a data de término da assinatura em um mês
            Calendar cal = Calendar.getInstance();
            if (subscription.getEndSubscription() != null) {
                cal.setTime(subscription.getEndSubscription());
            } else {
                cal.setTime(new Date());
            }
            cal.add(Calendar.MONTH, 1);
            subscription.setEndSubscription(cal.getTime());

            // Atualizar o status da assinatura
            subscription.setStatus("ATIVA");

            // Salvar a assinatura atualizada no repositório
            subscriptionRepository.save(subscription);
        }
    }
}