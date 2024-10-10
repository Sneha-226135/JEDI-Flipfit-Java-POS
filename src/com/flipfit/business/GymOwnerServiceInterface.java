package com.flipfit.business;

import java.util.ArrayList;

public interface GymOwnerServiceInterface {
    public String getOwnerDetails();
    public boolean viewAllSlots(int id);
    public boolean isApprovedGymOwner(int id);
    public boolean isApprovedGymCenter();
    public void addSlots();
    public boolean addGym(int id);
    public boolean createSlot(int id);
    public void viewAllGymCenters();
    public void viewAllApprovedGymCenters();
}
