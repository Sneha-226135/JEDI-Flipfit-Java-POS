package com.flipfit.business;

import com.flipfit.bean.BookedSlot;
import com.flipfit.bean.GymCenter;

import java.util.HashMap;
import java.util.List;

public class FlipfitCustomerService implements FlipfitCustomerInterface{

    public void createGymOwner(int userId, String name, String phone, String address, String pan_no, String gst_no) {
        createGymOwner(userId, name, phone, address, pan_no, gst_no);
        System.out.println("Customer Details are added!");
    }

    public void editProfile(int userId, String name, String phone, String address, String pan_no, String gst_no) {
        editProfile(userId, name, phone, address, pan_no, gst_no);
        System.out.println("edited gym owner details");
    }

    public void registerGym(int userId, String name, String location) {
        registerGym(userId, name, location);
        System.out.println("gym registered successfully");
    }

    public void editGym(int gymId, String gymName, String gymLocation) {
        editGym(gymId, gymName, gymLocation);
        System.out.println("gym " + gymId + " edited successfully");
    }

    public void removeGym(int gymId) {
        removeGym(gymId);
        System.out.println("gym " + gymId + " removed successfully");
    }

    public List<GymCenter> viewAllRegisteredGymCenters(int userId) {
        return viewAllRegisteredGymCenters(userId);
    }

    public List<BookedSlot> viewAllBookings(int userId) {
        return viewAllBookings(userId);
    }

    public List<BookedSlot> viewBookings(int gymId) {
        return viewBookings(gymId);

    }

    public HashMap<String,Integer> viewAvailableSlots(int gymId, String date) {
        try{
            return viewSlots(gymId,date);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public void addSlot(int gymId, int slotId, String slotTime, int slotCapacity, int slotPrice) {
        addSlot(gymId, slotId, slotTime, slotCapacity, slotPrice);
        System.out.println("Added slot " + slotId + " for gym " + gymId);
    }

    public void removeSlot(int gymId, int slotId) {
        removeSlot(gymId, slotId);
        System.out.println("Removed slot " + slotId + " for gym " + gymId);
    }

    @Override
    public void createCustomer(int userId, String name, String phoneNumber, String address) {

    }

    @Override
    public void editProfile(int userId, String name, String phoneNumber, String address) throws Exception {

    }

    @Override
    public List<GymCenter> viewGyms() {
        return List.of();
    }

    @Override
    public HashMap<String, Integer> viewSlots(int gymId, String date) {
        return null;
    }

    @Override
    public void filterSlots() {

    }
}
