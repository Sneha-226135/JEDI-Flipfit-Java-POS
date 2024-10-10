package com.flipfit.dao;

import com.flipfit.bean.GymOwner;

import java.util.ArrayList;

public class GymOwnerDAO {
    private static final ArrayList<GymOwner> owners = new ArrayList<GymOwner>();

    public static void add(GymOwner owner) {
        owners.add(owner);
        System.out.println("Gym owner data successfully added");
    }

    public static ArrayList<GymOwner> getGymOwners() {
        System.out.println("Listing out the GymOwners.\n");
        return owners;
    }
}
