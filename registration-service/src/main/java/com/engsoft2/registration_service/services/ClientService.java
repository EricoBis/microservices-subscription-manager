package com.engsoft2.registration_service.services;

import com.engsoft2.registration_service.repositories.ClientRepository;
import com.engsoft2.registration_service.services.dto.ClientDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

	private final ClientRepository clientRepository;

	@Autowired
	public ClientService(ClientRepository clientRepository) {
		this.clientRepository = clientRepository;
	}

	/**
	 * Get clients from database
	 * @return A list of clients
	 */
	public List<ClientDTO> getClients() {
		return clientRepository.findAll().stream().map(a -> new ClientDTO(a.getClientId(), a.getName(), a.getEmail())).toList();
	}

}
