package com.engsoft2.registration_service.entities;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long appId;
    private String name;
    private Double cost;

    @OneToMany(mappedBy = "application")
    private List<Subscription> subscriptions;

    public Long getAppId() {
        return appId;
    }

    public void setAppId(Long appId) {
        this.appId = appId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public List<Subscription> getSubscriptions() {
        return subscriptions;
    }

    public void setSubscriptions(List<Subscription> subscriptions) {
        this.subscriptions = subscriptions;
    }
}
