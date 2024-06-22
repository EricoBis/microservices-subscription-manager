package com.engsoft2.registration_service.services;

import com.engsoft2.registration_service.entities.Application;
import com.engsoft2.registration_service.repositories.ApplicationRepository;
import com.engsoft2.registration_service.services.dto.ApplicationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicationService {

	@Autowired
	private ApplicationRepository applicationRepository;

	@Autowired
	public ApplicationService(ApplicationRepository applicationRepository) {
		this.applicationRepository = applicationRepository;
	}

	public List<ApplicationDTO> getApplications() {
		return applicationRepository.findAll().stream().map(app -> new ApplicationDTO(app.getAppId(), app.getName(), app.getCost())).toList();
	}

    public ApplicationDTO updateApplicationCost(Long id, Double cost) {
        Application application = applicationRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Application not found"));
        application.setCost(cost);
        applicationRepository.save(application);
        return new ApplicationDTO(application.getAppId(), application.getName(), application.getCost());
    }
}
