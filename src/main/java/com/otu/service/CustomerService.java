package com.otu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.otu.model.Customer;
import com.otu.repository.CustomerRepository;


@Service
public class CustomerService {
	CustomerRepository repo;

	@Autowired
	public CustomerService(CustomerRepository repo) {
		super();
		this.repo = repo;
	}

	
	public boolean addCustomer(Customer customer) {
		if(!repo.existsById(customer.getId())) {
			System.out.println("creating customer");
			repo.save(customer);
			return true;
		}
		System.out.println("customer cant be created");
		return false;
	}
	

	
}