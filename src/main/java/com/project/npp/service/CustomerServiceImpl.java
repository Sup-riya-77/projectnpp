package com.project.npp.service;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.npp.entities.Customer;
import com.project.npp.entities.ERole;
import com.project.npp.entities.Role;
import com.project.npp.entities.Status;
import com.project.npp.entities.UserEntity;
import com.project.npp.exceptionmessages.QueryMapper;
import com.project.npp.exceptions.CustomerNotFoundException;
import com.project.npp.exceptions.RoleNotFoundException;
import com.project.npp.repositories.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	private static Logger loggers = LogManager.getLogger(CustomerServiceImpl.class);

	@Autowired
	private CustomerRepository repo;
	
	@Autowired
	private UserEntityService userEntityService;

	@Autowired
	private RoleService roleService;
	
	// Method to add a new customer
	@Override
	public Customer addCustomer(Customer customer) throws RoleNotFoundException {

		// Set status to PENDING by default
		customer.setStatus(Status.PENDING);
        UserEntity user= userEntityService.getUserEntity(customer.getUsername());
        Optional<Role> role= roleService.findRoleByName(ERole.ROLE_CUSTOMER);
        user.setRole(role.get());
		// Save customer to the repository
		Customer cust = repo.save(customer);
		loggers.info(QueryMapper.ADD_CUSTOMER);
		return cust;
	}

	// Method to get a customer by ID
	@Override
	public Customer getCustomerByCustomerId(Integer customerId) throws CustomerNotFoundException {
		Optional<Customer> cust = repo.findByCustomerId(customerId);
		if (cust.isPresent()) {
			loggers.info(QueryMapper.GET_CUSTOMER);
			return cust.get();
		} else
			loggers.error(QueryMapper.CANNOT_GET_CUSTOMER);
		throw new CustomerNotFoundException(QueryMapper.CANNOT_GET_CUSTOMER);
	}

	// Method to update an existing customer
	@Override
	public Customer updateCustomer(Customer customer) throws CustomerNotFoundException {
		Optional<Customer> c = repo.findById(customer.getUsername());
		if (c.isPresent()) {
			// Save the updated customer
			Customer cust = repo.save(customer);
			loggers.info(QueryMapper.UPDATE_CUSTOMER);
			return cust;
		} else
			loggers.error(QueryMapper.CANNOT_UPDATE_CUSTOMER);
		throw new CustomerNotFoundException(QueryMapper.CANNOT_UPDATE_CUSTOMER);
	}

	// Method to delete a customer by ID
	@Override
	public String deleteCustomerByUsername(String username) throws CustomerNotFoundException {
		Optional<Customer> cust = repo.findById(username);
		if (cust.isPresent()) {
			// Delete the customer from the repository
			repo.deleteById(username);
			loggers.info(QueryMapper.DELETE_CUSTOMER);
			return "Deleted Successfully!!";
		} else
			loggers.error(QueryMapper.CANNOT_DELETE_CUSTOMER);
		throw new CustomerNotFoundException(QueryMapper.CANNOT_DELETE_CUSTOMER);
	}

	// Method to get all customers
	@Override
	public List<Customer> getAllCustomers() throws CustomerNotFoundException {
		List<Customer> customers = (List<Customer>) repo.findAll();
		if (!customers.isEmpty()) {
			// Get all customers from the repository
			loggers.info(QueryMapper.GET_CUSTOMER);
			return customers;
		} else
			loggers.error(QueryMapper.CANNOT_GET_CUSTOMER);
		throw new CustomerNotFoundException(QueryMapper.CANNOT_GET_CUSTOMER);
	}

	@Override
	public Customer getCustomerByUsername(String username) throws CustomerNotFoundException {
		Optional<Customer> cust = repo.findById(username);
		if (cust.isPresent()) {
			loggers.info(QueryMapper.GET_CUSTOMER);
			return cust.get();
		} else
			loggers.error(QueryMapper.CANNOT_GET_CUSTOMER);
		throw new CustomerNotFoundException(QueryMapper.CANNOT_GET_CUSTOMER);
	}

}