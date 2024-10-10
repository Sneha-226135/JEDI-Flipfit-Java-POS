package com.flipfit.client;

import java.util.Scanner;

public class FlipfitGymOwnerMenu {
    public static void displayGymOwnerMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Gym Owner Menu:");
            System.out.println("1. View Gym Schedule");
            System.out.println("2. Manage Gym Classes");
            System.out.println("3. View Customers");
            System.out.println("4. Logout");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Viewing gym schedule...");
                    // Add logic to view gym schedule
                    break;
                case 2:
                    System.out.println("Managing gym classes...");
                    // Add logic to manage gym classes
                    break;
                case 3:
                    System.out.println("Viewing customers...");
                    // Add logic to view customers
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
