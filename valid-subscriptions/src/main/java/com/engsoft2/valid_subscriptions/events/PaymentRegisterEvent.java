package com.engsoft2.valid_subscriptions.events;

import com.engsoft2.valid_subscriptions.config.RabbitMQConfig;
import com.engsoft2.valid_subscriptions.dto.PaymentDTO;
import com.engsoft2.valid_subscriptions.services.SubscriptionService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PaymentRegisterEvent {

	private final SubscriptionService subscriptionService;

	@Autowired
	public PaymentRegisterEvent(SubscriptionService subscriptionService) {
		this.subscriptionService = subscriptionService;
	}

	@RabbitListener(queues = "${queue-name}")
	public void receive(PaymentDTO payment){
		System.out.println("Removendo!");
		subscriptionService.removeSubscription(payment.codass());
	}
}
