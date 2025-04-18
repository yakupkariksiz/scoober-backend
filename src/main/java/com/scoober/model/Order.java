package com.scoober.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("orders")
public class Order {
    @Id
    private String orderId;
    private Location location;
    private String status; // PLACED, ASSIGNED, DELIVERED
    private String courierId;
    private Integer etaMinutes;

    public Order() {}

    public String getOrderId() {
        return orderId;
    }

    public Location getLocation() {
        return location;
    }

    public String getStatus() {
        return status;
    }

    public String getCourierId() {
        return courierId;
    }

    public Integer getEtaMinutes() {
        return etaMinutes;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setCourierId(String courierId) {
        this.courierId = courierId;
    }

    public void setEtaMinutes(Integer etaMinutes) {
        this.etaMinutes = etaMinutes;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
}

