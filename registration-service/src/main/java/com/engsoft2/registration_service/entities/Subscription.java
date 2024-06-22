package com.engsoft2.registration_service.entities;

import com.engsoft2.registration_service.repositories.ApplicationRepository;
import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Subscription {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long subscription_id;
	@ManyToOne
	@JoinColumn(name = "application_id", nullable = false)
	private Application application_id;
	@ManyToOne
	@JoinColumn(name = "client_id", nullable = false)
	private Client client_id;
	private Date begin_subscription;
	private Date end_subscription;



}
