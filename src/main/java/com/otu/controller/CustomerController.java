package com.otu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.otu.model.Customer;
import com.otu.service.CustomerService;

@Controller
public class CustomerController {
	CustomerService service;
	
	@Autowired
	public CustomerController(CustomerService service) {
		super();
		this.service = service;
	}

	@GetMapping("/customers")
	public String customers(Model model) {
		model.addAttribute("customer", new Customer()); // empty obj for filling with data to add a new obj to repo
		model.addAttribute("existingCustomers", service.getCustomers()); // list<Obj> of all objs in the repo
		model.addAttribute("CustomerDropDowns", service.getDropDown()); // list<CustomerDropdowns> for use in drop downs
		
		return "customers";
	}
	
	@PostMapping("/processAddCustomer")
	public String processAddCustomer(Customer customer, Model model) {

		System.out.println(customer);
		
		boolean customerCreated = service.addCustomer(customer);
		
		model.addAttribute("customerAddedSuccessfully", customerCreated); // boolean for error text in the template
		
		if(customerCreated) {
			model.addAttribute("addedCustomerName", customer.getName());
		}
		
		return "redirect:/customers";
	}

	
}