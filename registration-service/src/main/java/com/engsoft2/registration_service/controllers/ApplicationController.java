package com.engsoft2.registration_service.controllers;

import com.engsoft2.registration_service.services.ApplicationService;
import com.engsoft2.registration_service.services.dto.ApplicationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/servcad")
public class ApplicationController {

    private ApplicationService applicationService;

    @Autowired
    public ApplicationController(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @GetMapping("/aplicativos")
    public List<ApplicationDTO> getApplications() {
        return applicationService.getApplications();
    }

    @PatchMapping("/aplicativos/{idAplicativo}")
    public ApplicationDTO updateApplicationCost(@PathVariable Long idAplicativo, @RequestBody ApplicationDTO applicationDTO) {
        return applicationService.updateApplicationCost(idAplicativo, applicationDTO.getCost());
    }
}