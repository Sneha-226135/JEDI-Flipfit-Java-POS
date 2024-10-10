package com.flipfit.dao;

import java.util.ArrayList;

import com.flipfit.bean.FlipfitAdmin;

public class AdminDAO {
    ArrayList<FlipfitAdmin> admins = new ArrayList<FlipfitAdmin>();
    public void add(FlipfitAdmin admin) {
        admins.add(admin);
        System.out.println("Admin data successfully added. \n");
    }
    public ArrayList<FlipfitAdmin> getAdmins() {
        System.out.println("Listing out the admins. \n");
        return admins;
    }
}
