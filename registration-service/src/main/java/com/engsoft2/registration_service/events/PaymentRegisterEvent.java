package com.engsoft2.registration_service.events;

import com.engsoft2.registration_service.entities.Subscription;
import com.engsoft2.registration_service.entities.SubscriptionStatus;
import com.engsoft2.registration_service.events.dto.PaymentDTO;
import com.engsoft2.registration_service.repositories.SubscriptionRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Optional;

@Component
public class PaymentRegisterEvent {

	public static final String QUEUENAME = "subscription.v1.payment-register";

	private final SubscriptionRepository subscriptionRepository;

	@Autowired
	public PaymentRegisterEvent(SubscriptionRepository subscriptionRepository) {
		this.subscriptionRepository = subscriptionRepository;
	}

	@RabbitListener(queues = QUEUENAME)
	public void receive(PaymentDTO payment) {

		Optional<Subscription> subscriptionOptional = subscriptionRepository.findById(payment.codass());

		if (subscriptionOptional.isEmpty())
			return;

		Subscription subscription = subscriptionOptional.get();

		int months = (int)Math.round(payment.paidValue() / subscription.getApplication().getCost());

		if (subscription.getStatus() == SubscriptionStatus.ATIVA) {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(subscription.getEndSubscription());

			calendar.add(Calendar.MONTH, months);

			subscription.setEndSubscription(calendar.getTime());
			subscriptionRepository.save(subscription);
		} else {
			Calendar calendar = Calendar.getInstance();
			subscription.setBeginSubscription(calendar.getTime());

			calendar.add(Calendar.MONTH, months);

			subscription.setEndSubscription(calendar.getTime());
			subscriptionRepository.save(subscription);
		}
	}
}
