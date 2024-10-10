package com.flipfit.business;

import com.flipfit.bean.GymCenter;

import java.util.HashMap;
import java.util.List;

public interface FlipfitCustomerInterface {
    public void createCustomer(int userId, String name, String phoneNumber, String address);

    public void editProfile(int userId, String name, String phoneNumber, String address) throws Exception;

    public List<GymCenter> viewGyms();

    public HashMap<String, Integer> viewSlots(int gymId, String date);

    public void filterSlots();

}
