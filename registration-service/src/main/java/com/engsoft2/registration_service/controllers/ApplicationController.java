package com.engsoft2.registration_service.controllers;

import com.engsoft2.registration_service.services.ApplicationService;
import com.engsoft2.registration_service.services.dto.ApplicationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ApplicationController {

    private final ApplicationService applicationService;

    @Autowired
    public ApplicationController(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    /**
     * Get applications from database
     * @return A list of applications
     */
    @GetMapping("/aplicativos")
    public List<ApplicationDTO> getApplications() {
        return applicationService.getApplications();
    }

    @PatchMapping("/aplicativos/{idAplicativo}")
    public ApplicationDTO updateApplicationCost(@PathVariable Long idAplicativo, @RequestBody ApplicationDTO applicationDTO) {
        return applicationService.updateApplicationCost(idAplicativo, applicationDTO.cost());
    }
}