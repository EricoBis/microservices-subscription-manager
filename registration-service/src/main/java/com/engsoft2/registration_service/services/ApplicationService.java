package com.engsoft2.registration_service.services;

import com.engsoft2.registration_service.entities.Application;
import com.engsoft2.registration_service.repositories.ApplicationRepository;
import com.engsoft2.registration_service.services.dto.ApplicationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicationService {

	private ApplicationRepository applicationRepository;

	@Autowired
	public ApplicationService(ApplicationRepository applicationRepository) {
		this.applicationRepository = applicationRepository;
	}

	public List<ApplicationDTO> getApplications() {
		return applicationRepository.findAll().stream().map(app -> new ApplicationDTO(app.getAppId(), app.getName(), app.getCost())).toList();
	}

}
