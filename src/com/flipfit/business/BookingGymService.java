package com.flipfit.business;

import com.flipfit.bean.BookedSlot;

import java.util.List;
import java.util.*;

public class BookingGymService implements BookingGymInterface {


    public void createBooking(int userId, int gymId, int transactionId, String bookingDate, String bookingTimeSlot, String bookingType, int bookingAmount) {
        try {
            createBooking(userId, gymId, transactionId, bookingDate, bookingTimeSlot, bookingType, bookingAmount);
            System.out.println("Booking is Done!!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void bookSlots() throws Exception {
        System.out.println("Slot is booked");
    }

    public List<BookedSlot> viewBookings(int userId) {
        return viewBookings(userId);
    }

    public void cancelBookings(int bookingId) {
        cancelBookings(bookingId);
        System.out.println("Booking is cancelled");
    }

    public int makePayment(int userId, String paymentDetails, String expiryDate, String modeOfPayment) throws Exception {
        try {
            System.out.println("Payment Successful!");
            return makePayment(userId, paymentDetails, expiryDate, modeOfPayment);
        } catch (Exception e) {
            System.out.println("Payment Failed!");
        }
        return 0;
    }
}
