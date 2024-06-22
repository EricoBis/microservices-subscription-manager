package com.engsoft2.registration_service.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Application {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long app_id;
	private String name;
	private Double cost;
	@OneToMany
	private List<Subscription> subscriptions;

	public Long getAppId() {
		return app_id;
	}

	public String getName() {
		return name;
	}

	public Double getCost() {
		return cost;
	}
}
