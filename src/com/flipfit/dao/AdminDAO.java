package com.flipfit.dao;

import java.util.ArrayList;

import com.flipfit.bean.FlipFitAdmin;

public class AdminDAO {
    ArrayList<FlipFitAdmin> admins = new ArrayList<FlipFitAdmin>();

    public void add(FlipFitAdmin admin) {
        admins.add(admin);
        System.out.println("Admin data successfully added");
    }
    public ArrayList<FlipFitAdmin> getGyms() {
        return admins;
    }
}
