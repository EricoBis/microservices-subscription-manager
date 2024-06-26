package com.engsoft2.registration_service.controllers;

import com.engsoft2.registration_service.services.SubscriptionService;
import com.engsoft2.registration_service.services.dto.SubscriptionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SubscriptionController {

    private final SubscriptionService subscriptionService;

    @Autowired
    public SubscriptionController(SubscriptionService subscriptionService) {
        this.subscriptionService = subscriptionService;
    }

    @GetMapping("/assinaturas/{tipo}")
    public List<SubscriptionDTO> getSubscriptionsByType(@PathVariable String tipo) {
        return subscriptionService.getSubscriptionsByType(tipo);
    }

    @GetMapping("/asscli/{codcli}")
    public List<SubscriptionDTO> getSubscriptionsByClientId(@PathVariable Long codcli) {
        return subscriptionService.getSubscriptionsByClientId(codcli);
    }

    @GetMapping("/assapp/{codapp}")
    public List<SubscriptionDTO> getSubscriptionsByAppId(@PathVariable Long codapp) {
        return subscriptionService.getSubscriptionsByAppId(codapp);
    }

    @PostMapping("/assinaturas")
    public SubscriptionDTO createSubscription(@RequestBody SubscriptionDTO subscriptionDTO) {
        return subscriptionService.createSubscription(subscriptionDTO.clientId(), subscriptionDTO.appId());
    }

    @GetMapping("/assinatura/{codass}")
    public ResponseEntity<SubscriptionDTO> getSubscriptionById(@PathVariable Long codass) {
        try {
            return new ResponseEntity<>(subscriptionService.getSubscription(codass), HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}