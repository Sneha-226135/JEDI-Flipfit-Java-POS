package com.flipfit.bean;
import java.util.Date;

public class Slot {
    private int gymId;
    public int getGymId() {
        return gymId;
    }
    public void setGymId(int gymId) {
        this.gymId = gymId;
    }
    public int getSlotId() {
        return slotId;
    }
    public void setSlotId(int slotId) {
        this.slotId = slotId;
    }
    public int getDate() {
        return date;
    }
    public void setDate(int date) {
        this.date = date;
    }
    public int getCustomerId() {
        return customerId;
    }
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }
    public String getTime() {
        return time;
    }
    public void setTime(String time) {
        this.time = time;
    }
    private int slotId;
    private int date;
    private int customerId;
    private String time;

}
