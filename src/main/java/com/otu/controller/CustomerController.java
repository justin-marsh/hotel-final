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

	@GetMapping("/addCustomer")
	public String addCustomer(Model model) {
		model.addAttribute("customer", new Customer());
		
		return "add-book-page";
	}
	
	@PostMapping("/processAddCustomer")
	public String processAddCustomer(Customer customer, Model model) {
		
		System.out.println(customer);
		//View    Controller    Service      Repository    DB
		boolean CustomerCreated = service.addCustomer(customer);
		
		if(CustomerCreated) {
			model.addAttribute("name", customer.getName());
			return "book-created";
		} else {
			return "redirect:/addCustomer";
		}		
	}
	

}