package com.engsoft2.registration_service.services.dto;

public class ClientDTO {
    private Long clientId;
    private String name;
    private String email;

    public ClientDTO(Long clientId, String name, String email) {
        this.clientId = clientId;
        this.name = name;
        this.email = email;
    }

    public Long getClientId() {
        return clientId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}