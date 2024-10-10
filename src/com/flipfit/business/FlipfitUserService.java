package com.flipfit.business;

import com.flipfit.bean.BookedSlot;

import java.util.List;

public class FlipfitUserService implements FlipfitUserInterface{
    public int authenticateUser(String email, String password, int roleId) {
        try {
            return authenticateUser(email, password, roleId);
        } catch (Exception e) {
            System.out.println(e);
            return 0;
        }
    }

    public int createUser(String email, String password, int roleId) {
        int userId = createUser(email, password, roleId);
        if (userId > 0) {
            System.out.println("User created");
            return userId;
        } else {
            System.out.println("User creation failed");
            return 0;
        }
    }

    @Override
    public void createBooking(int userId, int gymId, int transactionId, String bookingDate, String bookingTimeSlot, String bookingType, int bookingAmount) {

    }

    @Override
    public void bookSlots() throws Exception {

    }

    @Override
    public List<BookedSlot> viewBookings(int userId) throws Exception {
        return List.of();
    }

    @Override
    public void cancelBookings(int bookingId) throws Exception {

    }

    @Override
    public int makePayment(int userId, String paymentDetails, String expiryDate, String modeOfPayment) throws Exception {
        return 0;
    }
}
