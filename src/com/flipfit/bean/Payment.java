package com.flipfit.bean;

public class Payment {
    private int cardNum;
    private String custEmailAddress;
    public int getCardNum() {
        return cardNum;
    }
    public void setCardNum(int cardNum) {
        this.cardNum = cardNum;
    }
    public String getCustEmailAddress() {
        return custEmailAddress;
    }
    public void setCustEmailAddress(String custEmailAddress) {
        this.custEmailAddress = custEmailAddress;
    }
}
