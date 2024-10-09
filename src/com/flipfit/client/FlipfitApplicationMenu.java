package com.flipfit.client;
import java.util.Scanner;

public class FlipfitApplicationMenu {
    public static void mainPage() {
        System.out.println("Welcome to FlipFit Application");

        Scanner in = new Scanner(System.in);
        System.out.println("Enter the role");
        String role = in.next();

        if (role.equalsIgnoreCase("Admin")) {
            System.out.println("Welcome to Admin Menu");
            AdminGMSMenu admin = new AdminGMSMenu();
            admin.AdminPage(in);
        } else if (role.equalsIgnoreCase("Customer")) {
            System.out.println("Welcome to Customer Menu");
            CustomerGMSMenu customer = new CustomerGMSMenu();
            //while(true){
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = in.nextInt();
            switch (choice) {
                case 1:
                    customer.CustomerRegistration(in);
                    break;
                case 2:
                    login();
                    break;
                case 3:
                    GymApplicationClient.mainPage();
                    break;
                default:
                    System.out.println("Incorrect choice");
            }
        } else if (role.equalsIgnoreCase("GymOwner")) {
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            GymGMSMenu gymOwner = new GymGMSMenu();
            System.out.println("Enter your email: ");
            String email = in.next();
            switch (choice) {
                case 1:
                    gymOwner.registerGymOwner(in, email);
                    gymOwner.gymOwnerPage(in, email);
                    break;
                case 2:
                    gymOwner.gymOwnerPage(in, email);
                    break;
                case 3:
                    GymApplicationClient.mainPage();
                    break;
                default:
                    System.out.println("Incorrect choice");
            }
        }
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        CustomerService customerService = new CustomerService();
        AdminService adminService = new AdminService();
    }
}
