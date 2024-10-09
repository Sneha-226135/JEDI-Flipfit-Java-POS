package com.flipfit.business;

import com.flipfit.bean.Customer;
import java.util.ArrayList;
import java.util.List;

public class CustomerBusiness implements CustomerInterface {

    private List<Customer> customerList = new ArrayList<>();

    @Override
    public void createCustomer(String customerId, String customerName, String customerAddress) {
        Customer customer = new Customer();
        customer.setCustomerId(customerId);
        customer.setCustomerName(customerName);
        customer.setCustomerAddress(customerAddress);

        customerList.add(customer);
        System.out.println("Customer created:");
        System.out.println("customerId: " + customerId);
        System.out.println("customerName: " + customerName);
        System.out.println("customerAddress: " + customerAddress);
        System.out.println("<---Customer created successfully--->");
    }

    @Override
    public boolean deleteCustomer(String customerId) {
        System.out.println("<-- Deleting Customer by ID: " + customerId + " -->");
        return customerList.removeIf(customer -> customer.getCustomerId().equals(customerId));
    }

    @Override
    public boolean updateCustomer(String customerId, String newName, String newAddress) {
        for (Customer customer : customerList) {
            if (customer.getCustomerId().equals(customerId)) {
                customer.setCustomerName(newName);
                customer.setCustomerAddress(newAddress);
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
        for (Customer customer : customerList) {
            System.out.println("customerId: " + customer.getCustomerId());
            System.out.println("customerName: " + customer.getCustomerName());
            System.out.println("customerAddress: " + customer.getCustomerAddress());
            System.out.println("-------------------------");
        }
    }

}