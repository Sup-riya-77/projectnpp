package com.project.npp.service;

import java.util.List;

import com.project.npp.entities.Customer;
import com.project.npp.exceptions.CustomerNotFoundException;
import com.project.npp.exceptions.RoleNotFoundException;

public interface CustomerService {

	// Add customer
	public Customer addCustomer(Customer customer) throws RoleNotFoundException;

	// Get customer
	public Customer getCustomerByUsername(String  username) throws CustomerNotFoundException;
	
	// Get customer
		public Customer getCustomerByCustomerId(Integer  customerId) throws CustomerNotFoundException;

	// Update customer
	public Customer updateCustomer(Customer customer) throws CustomerNotFoundException;
	
	// Delete customer
	public String deleteCustomerByUsername(String  username) throws CustomerNotFoundException; 
	
	// Get all customers
	public List<Customer> getAllCustomers() throws CustomerNotFoundException;
}
