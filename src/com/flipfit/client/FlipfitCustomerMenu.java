package com.flipfit.client;
import com.flipfit.bean.Booking;
import com.flipfit.bean.FlipFitGym;
import com.flipfit.business.*;
import com.flipfit.business.FlipfitCustomerInterface;
import com.flipfit.business.FlipfitUserService;
import com.flipfit.exceptions.InvalidChoiceException;
import com.flipfit.exceptions.UserNotFoundException;
import com.flipfit.exceptions.WrongCredentialsException;

import java.time.LocalDateTime;
import java.util.*;

public class FlipfitCustomerMenu {

    /**
     * Handles customer login and redirects to the main menu upon successful login.
     *
     * @param email    The email of the customer.
     * @param password The password of the customer.
     * @throws UserNotFoundException    If the user is not found during login.
     * @throws WrongCredentialsException If the login credentials are incorrect.
     */
    public static void login(String email, String password) throws UserNotFoundException,WrongCredentialsException {
        FlipfitUserInterface user = new FlipfitUserService();
        int userId = user.authenticateUser(email, password, 1);
        LocalDateTime loginTime = LocalDateTime.now();
        if(userId > 0)
        {
            System.out.println("Logged in as Customer " + email );
            System.out.println("Login Time: " + loginTime);
            try {
                displayCustomerOptions(userId);}
            catch(InvalidChoiceException e){
                System.out.println("Error:"+e.getMessage());
            }
        }
        else{
            throw new WrongCredentialsException();
        }
    }

    /**
     * Displays various options for customers after successful login.
     *
     * @param userId The ID of the logged-in customer.
     * @throws UserNotFoundException    If the user is not found during operations.
     * @throws InvalidChoiceException   If an invalid menu choice is made.
     */
    public static void displayCustomerOptions(int userId) throws UserNotFoundException, InvalidChoiceException {
        FlipfitCustomerInterface customerService = new FlipfitCustomerService();
        BookingGymInterface bookingService = new BookingGymService();

        boolean flag = true;
        do{
            System.out.println("Welcome to FlipFit Customer Page");
            System.out.println("Customer Menu: \n1. Edit your Profile\n2. View all Gyms\n3. View available Slots\n 4. Book your slot\n5. View your bookings\n6. Cancel your bookings\n7. Exit");

            Scanner in = new Scanner(System.in);
            int i = in.nextInt();
            int gymId;
            String date;

            switch (i) {
                case 1:
                    String temp = in.nextLine();
                    System.out.println("Enter your name");
                    String name = in.nextLine();
                    System.out.println("Enter your phone number");
                    String phoneNumber = in.nextLine();
                    System.out.println("Enter your address");
                    String address = in.nextLine();

                    customerService.editProfile(userId, name, phoneNumber, address);
                    break;
                case 2:

                    List<FlipFitGym> gyms = customerService.viewGyms();
                    for (FlipFitGym gym : gyms) {
                        System.out.println("\nGym Id: " + gym.getGymId());
                        System.out.println("Gym: " + gym.getGymName());
                        System.out.println("Location: " + gym.getGymLocation());
                    }
                    System.out.println("All gyms viewed");
                    break;
                case 3:
                    String temp_ = in.nextLine();
                    System.out.println("Enter the id of the gym for which you want to view the available slots");
                    gymId = in.nextInt();
                    in.nextLine();
                    System.out.println("Enter the date of the slot");
                    date = in.nextLine();


                    HashMap<String,Integer> AvailableSlots = customerService.viewSlots(gymId,date);
                    // Print the available slots
                    for (Map.Entry<String, Integer> entry : AvailableSlots.entrySet()) {
                        System.out.println("Slot Time: " + entry.getKey() + ", Available Slots: " + entry.getValue());
                    }
                    System.out.println("All slots are viewed");
                    break;
//                case 4:
//
//                    customerService.filterSlots();
//                    break;
                case 4:
                    String temp2 = in.nextLine();
                    System.out.println("Enter your payment mode");
                    String modeOfPayment = in.nextLine();
                    System.out.println("Enter your payment details");
                    String paymentDetails = in.nextLine();
                    System.out.println("Enter your expiry date");
                    String expiryDate = in.nextLine();
                    int transactionId=1;
                    try{
                        transactionId = bookingService.makePayment(userId, paymentDetails, expiryDate, modeOfPayment);
                    }
                    catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    System.out.println("Enter gym id");
                    int gymBookingId = in.nextInt();
                    System.out.println("Enter booking date");
                    String temp3 = in.nextLine();
                    String bookingDate = in.nextLine();
                    System.out.println("Enter booking time slot");
                    String bookingTimeSlot = in.nextLine();
                    String bookingType = "Confirmed";
                    int bookingAmount = 100;
                    try{
                        bookingService.createBooking(userId, gymBookingId, transactionId, bookingDate, bookingTimeSlot, bookingType, bookingAmount);
                    }
                    catch (Exception e)
                    {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 5:
                    try{
                        List<Booking> bookings = bookingService.viewBookings(userId);

                        if (bookings.isEmpty()) {
                            System.out.println("No bookings found for userId: " + userId);
                        } else {
                            System.out.println("Bookings for userId: " + userId);
                            for (Booking booking : bookings) {
                                System.out.println("Booking ID: " + booking.getBookingId());
                                System.out.println("Customer ID: " + booking.getCustomerId());
                                System.out.println("Gym ID: " + booking.getGymId());
                                System.out.println("Transaction ID: " + booking.getTransactionId());
                                System.out.println("Booking Date: " + booking.getBookingDate());
                                System.out.println("Booking TimeSlot: " + booking.getBookingTimeSlot());
                                System.out.println("Booking Type: " + booking.getBookingType());
                                System.out.println("Booking Amount: " + booking.getBookingAmount());
                                System.out.println("=================================");
                            }
                        }
                    }
                    catch (Exception e)
                    {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 6:
                    System.out.println("Enter the bookingId");
                    int bookingId = in.nextInt();
                    try{
                        bookingService.cancelBookings(bookingId);
                    }catch(Exception e){
                        System.out.println(e.getMessage());
                    }

                    break;
                case 7:
                    System.out.println("Thank you for using FlipFit App");
                    flag = false;
                    break;
                default:
                    throw new InvalidChoiceException("Invalid option - " + i);
            }
        } while(flag);

    }

}