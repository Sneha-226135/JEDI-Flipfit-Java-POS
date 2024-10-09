package com.flipfit.client;

import java.util.Scanner;

public class FlipfitAdminMenu {
    public static void displayAdminMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Admin Menu:");
            System.out.println("1. View All Users");
            System.out.println("2. Manage Gym Owners");
            System.out.println("3. Manage Customers");
            System.out.println("4. Logout");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Viewing all users...");
                    // Add logic to view users
                    break;
                case 2:
                    System.out.println("Managing Gym Owners...");
                    // Add logic to manage gym owners
                    break;
                case 3:
                    System.out.println("Managing Customers...");
                    // Add logic to manage customers
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
