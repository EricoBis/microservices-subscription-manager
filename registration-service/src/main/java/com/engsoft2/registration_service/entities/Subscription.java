package com.engsoft2.registration_service.entities;

import com.engsoft2.registration_service.repositories.ApplicationRepository;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.util.Date;

@Entity
public class Subscription {

	private Long subscription_id;
	@ManyToOne
	@JoinColumn(name = "application_id", nullable = false)
	private Application application_id;
	private Client client_id;
	private Date begin_subscription;
	private Date end_subscription;



}
