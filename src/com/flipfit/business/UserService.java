package com.flipfit.business;

import com.flipfit.bean.FlipFitCustomer;

public class UserService {
	
	public String registerCustomer(FlipFitCustomer customerDetails){
		
		return "register customer";
	}
	
	public boolean getAdmin(int id) {
		System.out.println("get admin");
		return true;
	}
	
	public boolean viewAllCustomers(int id) {
		System.out.println("view all customers");
		return true;
	}
	
	public boolean viewAllGymOwners(int id) {
		System.out.println("view all gym owners");
		return true;
	}
	
	public void authenticateUser() {
		System.out.println("authenticate User");
	}
	
	public void registerGymOwner() {
		System.out.println("register Gym Owner");
	}
	
	public void registerUser() {
		System.out.println("register User");
	}
}
