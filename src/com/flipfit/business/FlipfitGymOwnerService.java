package com.flipfit.business;
import com.flipfit.bean.Booking;
import com.flipfit.bean.FlipFitGym;
import com.flipfit.bean.Slot;
import com.flipfit.dao.FlipfitCustomerDAOImpl;
import com.flipfit.dao.FlipfitCustomerDAOInterface;
import com.flipfit.dao.FlipfitGymOwnerDAOImpl;
import com.flipfit.dao.FlipfitGymOwnerDAOInterface;

import java.util.HashMap;
import java.util.List;

public class FlipfitGymOwnerService implements FlipfitGymOwnerInterface {

    FlipfitGymOwnerDAOInterface ownerDAO = new FlipfitGymOwnerDAOImpl();
    FlipfitCustomerDAOInterface customerDAO = new FlipfitCustomerDAOImpl();

    public void createGymOwner(int userId, String name, String phone, String address, String pan_no, String gst_no) {
        ownerDAO.createGymOwner(userId, name, phone, address, pan_no, gst_no);
        System.out.println("Gym owner Details are added!");
    }

    public void editProfile(int userId, String name, String phone, String address, String pan_no, String gst_no) {
        ownerDAO.editProfile(userId, name, phone, address, pan_no, gst_no);
        System.out.println("edited gym owner details");
    }

    public void registerGym(int userId, String name, String location) {
        ownerDAO.registerGym(userId, name, location);
        System.out.println("gym registered successfully");
    }

    public void editGym(int gymId, String gymName, String gymLocation) {
        ownerDAO.editGym(gymId, gymName, gymLocation);
        System.out.println("gym " + gymId + " edited successfully");
    }

    public void removeGym(int gymId) {
        ownerDAO.removeGym(gymId);
        System.out.println("gym " + gymId + " removed successfully");
    }

    public List<FlipFitGym> viewAllRegisteredGymCenters(int userId) {
        return ownerDAO.viewAllRegisteredGymCenters(userId);
    }

    public List<Booking> viewAllBookings(int userId) {
        return ownerDAO.viewAllBookings(userId);
    }

    public List<Booking> viewBookings(int gymId) {
        return ownerDAO.viewBookings(gymId);

    }

    public List<Slot> viewAvailableSlots(int gymId) {
        try{
            return ownerDAO.viewAvailableSlots(gymId);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public void addSlot(int gymId, int slotId, String slotTime, int slotCapacity, int slotPrice) {
        ownerDAO.addSlot(gymId, slotId, slotTime, slotCapacity, slotPrice);
        System.out.println("Added slot " + slotId + " for gym " + gymId);
    }

    public void removeSlot(int gymId, int slotId) {
        ownerDAO.removeSlot(gymId, slotId);
        System.out.println("Removed slot " + slotId + " for gym " + gymId);
    }

}