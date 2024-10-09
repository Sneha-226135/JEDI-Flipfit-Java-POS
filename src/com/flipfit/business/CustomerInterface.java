package com.flipfit.business;

public interface CustomerInterface {
    void createCustomer(String customerId, String customerName, String customerAddress);
    boolean deleteCustomer(String customerId);
    boolean updateCustomer(String customerId, String newName, String newAddress);
    void listCustomer();
}
