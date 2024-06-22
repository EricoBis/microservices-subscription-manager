package com.engsoft2.registration_service.services.dto;

import java.util.Date;

public class SubscriptionDTO {

    private Long subscriptionId;
    private Long clientId;
    private Long appId;
    private Date beginSubscription;
    private Date endSubscription;
    private String status;

    public SubscriptionDTO() {}

    public SubscriptionDTO(Long subscriptionId, Long clientId, Long appId, Date beginSubscription, Date endSubscription, String status) {
        this.subscriptionId = subscriptionId;
        this.clientId = clientId;
        this.appId = appId;
        this.beginSubscription = beginSubscription;
        this.endSubscription = endSubscription;
        this.status = status;
    }

    public Long getSubscriptionId() { return subscriptionId; }
    public void setSubscriptionId(Long subscriptionId) { this.subscriptionId = subscriptionId; }
    public Long getClientId() { return clientId; }
    public void setClientId(Long clientId) { this.clientId = clientId; }
    public Long getAppId() { return appId; }
    public void setAppId(Long appId) { this.appId = appId; }
    public Date getBeginSubscription() { return beginSubscription; }
    public void setBeginSubscription(Date beginSubscription) { this.beginSubscription = beginSubscription; }
    public Date getEndSubscription() { return endSubscription; }
    public void setEndSubscription(Date endSubscription) { this.endSubscription = endSubscription; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}