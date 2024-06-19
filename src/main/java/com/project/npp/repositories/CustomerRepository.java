package com.project.npp.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.npp.entities.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, String>{

	public Optional<Customer> findByCustomerId(Integer customerId);
}
