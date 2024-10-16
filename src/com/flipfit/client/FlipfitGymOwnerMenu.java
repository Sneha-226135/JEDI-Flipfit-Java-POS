package com.flipfit.client;

import com.flipfit.bean.Booking;
import com.flipfit.bean.FlipFitGym;
import com.flipfit.bean.Slot;
import com.flipfit.business.FlipfitGymOwnerInterface;
import com.flipfit.business.FlipfitGymOwnerService;
import com.flipfit.business.FlipfitUserInterface;
import com.flipfit.business.FlipfitUserService;
import com.flipfit.exceptions.InvalidChoiceException;
import com.flipfit.exceptions.WrongCredentialsException;

import java.time.LocalDateTime;
import java.util.*;

/**
 * Menu interface for FlipFit gym owners, providing various options like managing gyms,
 * slots, bookings, and profile editing.
 */
public class FlipfitGymOwnerMenu {

    /**
     * Handles gym owner login and redirects to the main menu upon successful login.
     *
     * @param email    The email of the gym owner.
     * @param password The password of the gym owner.
     * @throws WrongCredentialsException If the login credentials are incorrect.
     */
    public static void login(String email, String password) throws WrongCredentialsException
    {
        FlipfitUserInterface user = new FlipfitUserService();
        int userId = user.authenticateUser(email, password, 2);
        LocalDateTime loginTime = LocalDateTime.now();
        if(userId >0)
        {
            System.out.println("Logged in as Gym Owner");
            System.out.println("Login Time: " + loginTime);
            try {
                displayGymOwnerOptions(userId);
            } catch (InvalidChoiceException e) {
                System.out.println(e.getMessage());
            }
        }
        else{
            throw new WrongCredentialsException();
        }
    }
    /**
     * Displays various options for gym owners after successful login.
     *
     * @param userId The ID of the logged-in gym owner.
     * @throws InvalidChoiceException If an invalid menu choice is made.
     */
    public static void displayGymOwnerOptions(int userId) throws InvalidChoiceException {

        FlipfitGymOwnerInterface gymOwnerService = new FlipfitGymOwnerService();
        boolean flag = true;

        do {
            System.out.println("GymOwnerMenu:\n 1.Register a Gym\n 2.Edit Gym details\n 3.Remove a Gym\n " +
                    "4.Add new slot\n 5.Remove slot\n 6.View Available slots\n 7.View All Bookings\n " + "8.Edit Profile\n 9.Exit\n");

            Scanner in = new Scanner(System.in);
            int i = in.nextInt();
            String name, location, temp, slotTime, panNum, gstNum, phoneNumber, address;
            int gymId,slotId,slotCapacity, slotPrice;
            List<Booking> bookings;

            switch(i){
                case 1:
                    temp = in.nextLine();
                    System.out.println("Enter gym name");
                    name = in.nextLine();
                    System.out.println("Enter location");
                    location = in.nextLine();
                    gymOwnerService.registerGym(userId, name, location);
                    break;
                case 2:
                    System.out.println("Enter gym id of gym to be modified");
                    gymId = in.nextInt();
                    temp = in.nextLine();
                    System.out.println("Enter gym name");
                    name = in.nextLine();
                    System.out.println("Enter location");
                    location = in.nextLine();
                    gymOwnerService.editGym(gymId, name, location);
                    break;
                case 3:
                    System.out.println("Enter gym id of gym to be removed");
                    gymId = in.nextInt();
                    gymOwnerService.removeGym(gymId);
                    break;
                case 4:
                    System.out.println("Enter gym id ");
                    gymId = in.nextInt();
                    System.out.println("Enter slot id ");
                    slotId = in.nextInt();
                    temp = in.nextLine();
                    System.out.println("Enter slot timings");
                    slotTime = in.nextLine();
                    System.out.println("Enter slot capacity");
                    slotCapacity = in.nextInt();
                    System.out.println("Enter slot price");
                    slotPrice = in.nextInt();
                    gymOwnerService.addSlot(gymId, slotId, slotTime, slotCapacity, slotPrice);
                    break;
                case 5:
                    System.out.println("Enter gym id ");
                    gymId = in.nextInt();
                    System.out.println("Enter slot id ");
                    slotId = in.nextInt();
                    gymOwnerService.removeSlot(gymId, slotId);
                    break;
                case 6:
                    in.nextLine();
                    System.out.println("Enter gym id ");
                    gymId = in.nextInt();
                    in.nextLine();
                    System.out.println("Enter the date of the slot");
                    String date = in.nextLine();

                   List<Slot> AvailableSlots = gymOwnerService.viewAvailableSlots(gymId);
                    // Print the available slots
                    for (Slot slot : AvailableSlots) {
                        System.out.println("Slot Time: " + slot.getSlotTime() + ", Available Slots: " + slot.getSlotCapacity());
                    }
                    System.out.println("viewed available slots for " + gymId);
                    break;
                case 7:

                    bookings = gymOwnerService.viewAllBookings(userId);
                    for (Booking booking : bookings) {
                        System.out.println("\nBooking Id: " + booking.getBookingId());
                        System.out.println("Customer Id: " + booking.getCustomerId());
                        System.out.println("Gym Id: " + booking.getGymId());
                        System.out.println("Booking Date: " + booking.getBookingDate());
                        System.out.println("Slot: " + booking.getBookingTimeSlot());
                        System.out.println("Transaction  Id: " + booking.getTransactionId());
                    }
                    System.out.println("viewed all bookings");
                    break;
//                case 8:
//                    System.out.println("Enter gym id ");
//                    gymId = in.nextInt();
//
//                    bookings = gymOwnerService.viewBookings(gymId);
//                    for (Booking booking : bookings) {
//                        System.out.println("\nBooking Id: " + booking.getBookingId());
//                        System.out.println("Customer Id: " + booking.getCustomerId());
//                        System.out.println("Booking Date: " + booking.getBookingDate());
//                        System.out.println("Slot: " + booking.getBookingTimeSlot());
//                        System.out.println("Transaction  Id: " + booking.getTransactionId());
//                    }
//                    System.out.println("viewed bookings for " + gymId);
//                    break;
//                case 8:
//
//                    List<FlipFitGym> gyms = gymOwnerService.viewAllRegisteredGymCenters(userId);
//                    for (FlipFitGym gym : gyms) {
//                        System.out.println("\nGym Id: " + gym.getGymId());
//                        System.out.println("Gym: " + gym.getGymName());
//                        System.out.println("Location: " + gym.getGymLocation());
//                    }
//                    System.out.println("view All Gym Centers");
//                    break;
                case 8:
                    temp = in.nextLine();
                    System.out.println("Enter your name");
                    name = in.nextLine();
                    System.out.println("Enter your phone number");
                    phoneNumber = in.nextLine();
                    System.out.println("Enter your address");
                    address = in.nextLine();
                    System.out.println("Enter your Pan Number");
                    panNum = in.next();
                    System.out.println("Enter your GST Number");
                    gstNum = in.next();
                    gymOwnerService.editProfile(userId, name, phoneNumber, address, panNum, gstNum);
                    break;
                case 9:
                    System.out.println("Thank you for using FlipFit Application");
                    flag = false;
                    break;
                default:
                    throw new InvalidChoiceException("Invalid option - " + i);
            }

        } while(flag);

    }
}