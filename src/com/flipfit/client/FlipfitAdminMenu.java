package com.flipfit.client;
import java.util.*;

public class FlipfitAdminMenu {
     public void viewAllGymOwners(){

     }
     public void viewPendingGymOwners(){

     }
     public void viewAllGyms(){

     }

     public void viewPendingGymCentres(){

     }

     public void approveGymOwner(){

     }
     public  void approveGymCentre(){

     }

    public void AdminPage() throws Exception {
        while(true) {
            System.out.println("1. View All Gym Owners");
            System.out.println("2. View All Pending Gym Owners");
            System.out.println("3. View All Gym Centres");
            System.out.println("4. View All Pending Gym Centres");
            System.out.println("5. Approve Gym Owner");
            System.out.println("6. Approve Gym Centre");
            System.out.println("7. Exit");
            System.out.print("Enter number: ");
            int choice = in.nextInt();
            switch (choice) {
                case 1:
                    viewAllGymOwners();
                    break;
                case 2:
                    viewPendingGymOwners();
                    break;
                case 3:
                    viewAllGyms();
                    break;
                case 4:
                    viewPendingGymCentres();
                    break;
                case 5:
                    approveGymOwner();
                    break;
                case 6:
                    approveGymCentre();
                    break;
                case 7:
                    GymApplicationClient.mainPage();
                    break;
                default:
                    System.out.println("Invalid number");
            }
        }

    }

    public static void AdminMenu() {
        AdminService adminService = new AdminService();
        Admin admin = new Admin();
        Scanner in = new Scanner(System.in);
        int option;

        System.out.println("1. Approve Gym Owner Registration");
        System.out.println("2. View List of Registered Gyms by id");
        System.out.println("3. View List of Registered Gyms by name");
        System.out.println("4. View List of Pending Gyms by id");
        System.out.println("5. View List of Pending Gyms by name");
        System.out.println("6. View List of Registered Customers");
        System.out.println("7. Edit Admin Profile");
        System.out.println("8. Exit");
        option = in.nextInt();

        if(option == 7) {
            System.out.println("1. Edit name");
            System.out.println("2. Edit email address");
            System.out.println("3. Edit phone");

            int subOption = in.nextInt();

            if(subOption == 1) {
                String name = in.next();
                admin.setAdminName(name);
                System.out.println("Name changed successfully");
            }

            if(subOption == 2) {
                String email = in.next();
                admin.setAdminEmailAddress(email);
                System.out.println("Email changed successfully");
            }

            if(subOption == 3) {
                int phone = in.nextInt();
                admin.setAdminPhone(phone);
                System.out.println("Contact number changed successfully");
            }

        }

        if(option == 8) {
            GymApplicationClient gymApplication = new GymApplicationClient();
            gymApplication.main(null);
        }
    }


}
