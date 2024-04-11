package com.otu.service;

import java.util.ArrayList;
import java.util.Collections;
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
	
	public boolean validateCustomer(long id) {
		return repo.existsById(id);
	}
	
	public List<Customer> getCustomers() {
        return repo.findAll();
    }

	public boolean validateCustomer(Customer customer) {
		return repo.existsById(customer.getId());
	}
	
	
	class CustomerDropdown //for use in below function
	{
	    public String display;
	    public Customer customer;
	};
	public List<CustomerDropdown> getDropDown() {
		List<CustomerDropdown> ret = new ArrayList<CustomerDropdown>();
		List<Customer> Customers = getCustomers();
	
		for(Customer i :Customers) {
			
			CustomerDropdown cdrop = new CustomerDropdown();
			
			if(repo.findByName(i.getName()).size() > 1 ) {
				cdrop.display = i.getName() + " " + i.getPhoneNumber();
			}else {
				cdrop.display = i.getName();
			}
			
			cdrop.customer = i;
			
			ret.add(cdrop);
		}
		
		return ret;
		
	}
	
	public List<Customer> findByName(String name) {
		return repo.findByName(name);
	}
	
	public List<Customer> findByPhoneNumber(String phoneNumber) {
		return repo.findByPhoneNumber(phoneNumber);
	}
	
	public List<Customer> findByEmail(String email) {
		return repo.findByEmail(email);
	}
	
}