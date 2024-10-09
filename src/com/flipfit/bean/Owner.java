package com.flipfit.bean;

public class Owner {
    private String ownerId;
    private String ownerName;
    private String ownerAddress;

    public String getCustomerId() {
        return ownerId;
    }

    public void setCustomerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public String getCustomerName() {
        return ownerName;
    }

    public void setCustomerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getCustomerAddress() {
        return ownerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.ownerAddress = ownerAddress;
    }
}
