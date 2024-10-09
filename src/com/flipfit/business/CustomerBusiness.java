package com.flipfit.business;

import com.flipfit.bean.FlipFitCustomer;
import java.util.ArrayList;
import java.util.List;

public class CustomerBusiness implements CustomerInterface {

    private List<FlipFitCustomer> flipFitCustomerList = new ArrayList<>();

    @Override
    public void createCustomer(String customerId, String customerName, String customerAddress) {
        FlipFitCustomer flipFitCustomer = new FlipFitCustomer();
        flipFitCustomer.setCustomerId(customerId);
        flipFitCustomer.setCustomerName(customerName);
        flipFitCustomer.setCustomerAddress(customerAddress);

        flipFitCustomerList.add(flipFitCustomer);
        System.out.println("Customer created:");
        System.out.println("customerId: " + customerId);
        System.out.println("customerName: " + customerName);
        System.out.println("customerAddress: " + customerAddress);
        System.out.println("<---Customer created successfully--->");
    }

    @Override
    public boolean deleteCustomer(String customerId) {
        System.out.println("<-- Deleting Customer by ID: " + customerId + " -->");
        return flipFitCustomerList.removeIf(flipFitCustomer -> flipFitCustomer.getCustomerId().equals(customerId));
    }

    @Override
    public boolean updateCustomer(String customerId, String newName, String newAddress) {
        for (FlipFitCustomer flipFitCustomer : flipFitCustomerList) {
            if (flipFitCustomer.getCustomerId().equals(customerId)) {
                flipFitCustomer.setCustomerName(newName);
                flipFitCustomer.setCustomerAddress(newAddress);
                System.out.println("<--- Customer updated successfully --->");
                return true;
            }
        }
        System.out.println("<--- Customer not found for ID: " + customerId + " --->");
        return false;
    }

    @Override
    public void listCustomer() {
        System.out.println("Listing customers:");
        for (FlipFitCustomer flipFitCustomer : flipFitCustomerList) {
            System.out.println("customerId: " + flipFitCustomer.getCustomerId());
            System.out.println("customerName: " + flipFitCustomer.getCustomerName());
            System.out.println("customerAddress: " + flipFitCustomer.getCustomerAddress());
            System.out.println("-------------------------");
        }
    }

}
