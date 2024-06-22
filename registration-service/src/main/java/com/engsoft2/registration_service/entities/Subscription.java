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

    public void setSubscriptionId(Long subscriptionId) {
        this.subscriptionId = subscriptionId;
    }

    public Application getApplication() {
        return application;
    }

    public void setApplication(Application application) {
        this.application = application;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Date getBeginSubscription() {
        return beginSubscription;
    }

    public void setBeginSubscription(Date beginSubscription) {
        this.beginSubscription = beginSubscription;
    }

    public Date getEndSubscription() {
        return endSubscription;
    }

    public void setEndSubscription(Date endSubscription) {
        this.endSubscription = endSubscription;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
