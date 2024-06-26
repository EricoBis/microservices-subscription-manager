package com.engsoft2.valid_subscriptions.services;

import com.engsoft2.valid_subscriptions.dto.ResponseSubscriptionDTO;
import com.engsoft2.valid_subscriptions.dto.SubscriptionStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.HashMap;

@Service
public class SubscriptionService {

	public HashMap<Long, Date> subscriptions;
	private RestTemplate restTemplate;


	@Autowired
	public SubscriptionService(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
		subscriptions = new HashMap<>();
	}

	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	public boolean checkSubscription(Long id) {
		if (subscriptions.containsKey(id)) {
			Date date = subscriptions.get(id);

			System.out.println("Cached!");
			return date.after(new Date());
		}

		try {
			ResponseEntity<ResponseSubscriptionDTO> response = restTemplate.getForEntity("http://registration-service/assinatura/" + id, ResponseSubscriptionDTO.class);

			if (response.getStatusCode().is2xxSuccessful() && response.hasBody()){
				ResponseSubscriptionDTO subscription = response.getBody();
				subscriptions.put(id, subscription.endSubscription());

				return subscription.status() == SubscriptionStatus.ATIVA;
			}
		} catch (Exception e) {
			return false;
		}
		return false;
	}

	public void removeSubscription(Long id) {
		subscriptions.remove(id);
	}

}
