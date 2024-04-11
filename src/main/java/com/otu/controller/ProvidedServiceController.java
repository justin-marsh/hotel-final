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
public class ProvidedServiceController {
	com.otu.service.ProvidedService service;
	
	@Autowired
	public ProvidedServiceController(com.otu.service.ProvidedService service) {
		super();
		this.service = service;
	}

	@GetMapping("/Services")
	public String servicespage(Model model) {
		model.addAttribute("customer", new Customer());
		
		return "s";
	}
	
	@PostMapping("/processAddService")
	public String processAddService(com.otu.model.ProvidedService serviceOBJ, Model model) {
		
		System.out.println(serviceOBJ);
		//View    Controller    Service      Repository    DB
		boolean ServiceCreated = service.addService(serviceOBJ);
		
		if(ServiceCreated) {
			model.addAttribute("name", serviceOBJ.getName());
			return "Service-created";
		} else {
			return "redirect:/Services";
		}		
	}
	

}