package com.flipfit.client;

import com.flipfit.bean.FlipFitGymOwner;
import com.flipfit.business.FlipfitAdminInterface ;
import com.flipfit.business.FlipfitAdminService;
import com.flipfit.business.FlipfitUserService;
import com.flipfit.exceptions.InvalidChoiceException;
import com.flipfit.exceptions.WrongCredentialsException;
import com.flipfit.business.FlipfitUserInterface;


import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

/**
 * A client class that simulates an admin menu for managing gym owners in the FlipFit application.
 */
public class FlipfitAdminMenu {

    /**
     * Authenticates the admin user based on the provided email, password, and role ID.
     *
     * @param email    The email of the admin user.
     * @param password The password of the admin user.
     * @throws WrongCredentialsException If the authentication fails due to incorrect credentials.
     */

    public static void login(String email, String password) throws WrongCredentialsException
    {
        FlipfitUserInterface user = new FlipfitUserService();
        LocalDateTime loginTime = LocalDateTime.now();
        if(user.authenticateUser(email, password, 3) > 0)
        {
            System.out.println("Logged in as Admin");
            System.out.println("Login Time: " + loginTime);
            try {
                displayAdminOptions();
            } catch (InvalidChoiceException e) {
                System.out.println("Error: "+e.getMessage());
            }
        }
        else{
            throw new WrongCredentialsException();
        }

    }

    /**
     * Displays the admin menu options and handles user input to execute corresponding actions.
     *
     * @throws InvalidChoiceException If an invalid menu choice is entered by the admin.
     */

    public static void displayAdminOptions() throws InvalidChoiceException {
        FlipfitAdminInterface adminService = new FlipfitAdminService() ;
        boolean flag= true ;
        int gymOwnerId;
        List<FlipFitGymOwner> gymOwners;
        do {
            System.out.println("Welcome to admin page : ");
            System.out.println("1. View all Gym Owners \n2. View all details of gym owner \n3. View requests of gym owners \n4. Approval of gym owner requests \n5. Remove any gym owner \n6. Cancel any pending request \n7. Exit");
            Scanner sc = new Scanner(System.in);
            int option = sc.nextInt();
            switch (option) {
                case 1:
                    gymOwners = adminService.viewAllGymOwners();
                    for(FlipFitGymOwner s: gymOwners){
                        System.out.println("Owner ID: " + s.getOwnerId() + " ---> " + "Owner Name: " + s.getOwnerName());
                    }
                    break;
                case 2:
                    String temp = sc.nextLine();
                    System.out.println("Enter Gym Owner ID : ");
                    gymOwnerId = sc.nextInt();

                    gymOwners = adminService.viewGymOwnerDetails(gymOwnerId);
                    for(FlipFitGymOwner s : gymOwners){
                        System.out.println("ID: " + s.getOwnerId());
                        System.out.println("Name: " + s.getOwnerName());
                        System.out.println("Phone: " + s.getOwnerId());
                        System.out.println("Address: " + s.getOwnerAddress());
                        System.out.println("GST Number: " + s.getOwnerGstNum());
                        System.out.println("PAN Number: " + s.getOwnerPanNum());
                        System.out.println("Approval Status: " + s.getApprovalStatus());
                        System.out.println("=================================");
                    }
                    System.out.println("Viewed All the approved gym owner details");
                    break;
                case 3:
                    List<FlipFitGymOwner> Output = adminService.viewGymOwnerRequests();
                    for(FlipFitGymOwner s : Output){
                        System.out.println("ID: " + s.getOwnerId());
                        System.out.println("Name: " + s.getOwnerName());
                        System.out.println("Phone: " + s.getOwnerId());
                        System.out.println("Address: " + s.getOwnerAddress());
                        System.out.println("GST Number: " + s.getOwnerGstNum());
                        System.out.println("PAN Number: " + s.getOwnerPanNum());
                        System.out.println("Approval Status: " + s.getApprovalStatus());
                        System.out.println("=================================");
                    }
                    System.out.println("Viewed all the gym owner pending requests");
                    break;
                case 4:
                    String temp_ = sc.nextLine();
                    System.out.println("Enter Gym Owner ID : ");
                    gymOwnerId = sc.nextInt();
                    adminService.approveGymOwnerRequests(gymOwnerId);
                    break;
                case 5:
                    String _temp = sc.nextLine();
                    System.out.println("Enter Gym Owner ID : ");
                    gymOwnerId = sc.nextInt();
                    adminService.removeGymOwner(gymOwnerId);
                    break;
                case 6:
                    String _temp_ = sc.nextLine();
                    System.out.println("Enter Gym Owner ID : ");
                    gymOwnerId = sc.nextInt();
                    adminService.cancelRequest(gymOwnerId);
                    break;
                case 7:
                    System.out.println("Thank you for using FlipFit App");
                    flag= false ;
                    break;
                default:
                    System.out.println("invalid option");
            }
        }while(flag);

    }
}