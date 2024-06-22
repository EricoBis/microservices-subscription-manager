package com.engsoft2.registration_service.entities;

import jakarta.persistence.*;

@Entity
public class Client {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long client_id;
	private String name;
	private String email;

	public Long getClientId() {
		return client_id;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}
}
