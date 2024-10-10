package com.flipfit.client;

import java.util.Scanner;

public class FlipfitCustomerMenu {
    public static void displayCustomerMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Customer Menu:");
            System.out.println("1. View Gym Classes");
            System.out.println("2. Book a Gym Class");
            System.out.println("3. View Membership");
            System.out.println("4. Logout");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Viewing gym classes...");
                    // Add logic to view gym classes
                    break;
                case 2:
                    System.out.println("Booking a gym class...");
                    // Add logic to book a gym class
                    break;
                case 3:
                    System.out.println("Viewing membership...");
                    // Add logic to view membership
                    break;
                case 4:
                    System.out.println("Logging out...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);
    }
}