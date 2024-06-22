package com.engsoft2.registration_service.controllers;

import com.engsoft2.registration_service.services.ClientService;
import com.engsoft2.registration_service.services.dto.ClientDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ClientController {

	private ClientService clientService;

	@Autowired
	public ClientController(ClientService clientService) {
		this.clientService = clientService;
	}

	@GetMapping("/clientes")
	public List<ClientDTO> getClients() {
		return clientService.getClients();
	}
}
