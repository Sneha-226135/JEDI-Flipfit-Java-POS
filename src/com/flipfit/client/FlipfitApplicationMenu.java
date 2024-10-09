package com.flipfit.client;

import java.util.Scanner;

public class FlipfitApplicationMenu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("Welcome to Flipfit Application:");
            System.out.println("1. Login");
            System.out.println("2. Registration of the Customer");
            System.out.println("3. Registration of GymOwner");
            System.out.println("4. Update password");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    login();
                    break;
                case 2:
                    System.out.println("Customer Registration");
                    // Add registration logic here
                    break;
                case 3:
                    System.out.println("Gym Owner Registration");
                    // Add registration logic here
                    break;
                case 4:
                    System.out.println("Update Password");
                    // Add password update logic here
                    break;
                case 5:
                    System.out.println("Exiting application. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);

        scanner.close();
    }

    public static void login() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        System.out.print("Enter role (Admin/Owner/Customer): ");
        String role = scanner.nextLine();

        switch (role.toLowerCase()) {
            case "admin":
                FlipfitAdminMenu.displayAdminMenu();
                break;
            case "owner":
                FlipfitGymOwnerMenu.displayGymOwnerMenu();
                break;
            case "customer":
                FlipfitCustomerMenu.displayCustomerMenu();
                break;
            default:
                System.out.println("Invalid role! Please enter Admin, Owner, or Customer.");
        }
    }
}
