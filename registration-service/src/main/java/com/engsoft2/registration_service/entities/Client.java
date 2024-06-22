package com.engsoft2.registration_service.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Client {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long client_id;
	private String name;
	private String email;

	@OneToMany
	private List<Subscription> subscription;

	public Long getClientId() {
		return client_id;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public List<Subscription> getSubscription() {
		return subscription;
	}
}
