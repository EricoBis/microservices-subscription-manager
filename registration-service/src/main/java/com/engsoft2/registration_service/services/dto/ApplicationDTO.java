package com.engsoft2.registration_service.services.dto;

public class ApplicationDTO {
    private Long appId;
    private String name;
    private Double cost;

    public ApplicationDTO(Long appId, String name, Double cost) {
        this.appId = appId;
        this.name = name;
        this.cost = cost;
    }

    public Long getAppId() {
        return appId;
    }

    public String getName() {
        return name;
    }

    public Double getCost() {
        return cost;
    }

    public void setAppId(Long appId) {
        this.appId = appId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }
}