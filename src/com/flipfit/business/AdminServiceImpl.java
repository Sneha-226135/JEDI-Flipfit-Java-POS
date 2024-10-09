package com.flipfit.business;
import com.flipfit.bean.FlipFitAdmin;
import com.flipfit.bean.GymOwner;
import com.flipfit.bean.GymCenter;
import com.flipfit.dao.AdminDAO;
import com.flipfit.dao.GymOwnerDAO;
import com.flipfit.dao.GymDAO;

import java.util.ArrayList;

public class AdminServiceImpl implements AdminService{
    AdminDAO adminDatabase = new AdminDAO();
    FlipFitAdmin admin = new FlipFitAdmin();

    @Override
    public void createAdmin(int id, String name, String emailAddress, int phone, String password) {

        admin.setAdminEmailAddress(emailAddress);
        admin.setAdminName(name);
        admin.setAdminId(id);
        admin.setPhone(phone);
        admin.setPassword(password);
        adminDatabase.add(admin);

        System.out.println("admin details added");
    }

    @Override
    public void approveGymRegistration(GymCenter g) {
        GymDAO.add(g);
    }

    @Override
    public void approveGymOwnerRegistration(GymOwner g) {
        GymOwnerDAO.add(g);
    }

    @Override
    public ArrayList<GymOwner> viewAllApprovedGymOwners() {
        return GymOwnerDAO.getGymOwners();
    }

    @Override
    public ArrayList<GymCenter>  viewAllApprovedGyms() {
        return GymDAO.getGyms();
    }
}
