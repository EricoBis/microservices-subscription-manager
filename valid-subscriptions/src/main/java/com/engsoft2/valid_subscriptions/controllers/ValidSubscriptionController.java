package com.engsoft2.valid_subscriptions.controllers;

import com.engsoft2.valid_subscriptions.services.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ValidSubscriptionController {


	private final SubscriptionService subscriptionService;

	@Autowired
	public ValidSubscriptionController(SubscriptionService subscriptionService) {
		this.subscriptionService = subscriptionService;
	}

	@GetMapping("/assinvalidas/{codass}")
	public boolean checkSubscription(@PathVariable("codass") Long codass) {
		return subscriptionService.checkSubscription(codass);
	}

}
