package com.engsoft2.registration_service.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Subscription {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long subscriptionId;
    @ManyToOne
    @JoinColumn(name = "application_id", nullable = false)
    private Application application;
    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;
    private Date beginSubscription;
    private Date endSubscription;
    private String status;

    public Long getSubscriptionId() {
        return subscriptionId;
    }

    public Application getApplication() {
        return application;
    }

    public Client getClient() {
        return client;
    }

    public Date getBeginSubscription() {
        return beginSubscription;
    }

    public Date getEndSubscription() {
        return endSubscription;
    }

    public String getStatus() {
        return status;
    }

    public void setEndSubscription(Date endSubscription) {
        this.endSubscription = endSubscription;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}