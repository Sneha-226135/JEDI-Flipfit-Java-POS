package com.flipfit.dao;

import java.util.ArrayList;

import com.flipfit.bean.FlipFitAdmin;

public class AdminDAO {
    ArrayList<FlipFitAdmin> admins = new ArrayList<FlipFitAdmin>();
    public void add(FlipFitAdmin admin) {
        admins.add(admin);
        System.out.println("Admin data successfully added. \n");
    }
    public ArrayList<FlipFitAdmin> getAdmins() {
        System.out.println("Listing out the admins. \n");
        return admins;
    }
}
