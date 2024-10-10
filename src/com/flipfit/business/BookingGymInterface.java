package com.flipfit.business;

import com.flipfit.bean.BookedSlot;

import java.util.List;

public interface BookingGymInterface {

        public void bookSlots() throws Exception;

        public List<BookedSlot> viewBookings(int userId) throws Exception;

        public void cancelBookings(int bookingId) throws Exception;

        public int makePayment(int userId, String paymentDetails, String expiryDate, String modeOfPayment) throws Exception;
}
