package com.flipfit.business;

import com.flipfit.bean.GymOwner;
import com.flipfit.bean.GymCenter;
import java.util.ArrayList;

public interface AdminService {
    public void createAdmin(int id, String name, String emailAddress, int phone, String password);
    public void approveGymRegistration(GymCenter g);
    public void approveGymOwnerRegistration(GymOwner g);
    public ArrayList<GymOwner> viewAllApprovedGymOwners();
    public ArrayList<GymCenter> viewAllApprovedGyms();
}
