package com.otu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.otu.model.ProvidedService;
import com.otu.service.ProvidedServiceService;

@Controller
public class ProvidedServiceController {
	ProvidedServiceService service;
	
	@Autowired
	public ProvidedServiceController(ProvidedServiceService service) {
		super();
		this.service = service;
	}

	@GetMapping("/services")
	public String services(Model model) {
		model.addAttribute("booking", new com.otu.model.ProvidedService()); // empty obj for filling with data to add a new obj to repo
		model.addAttribute("existingServices", service.getProvidedServices()); // list<Obj> of all objs in the repo
		
		return "services";
	}
	
	@PostMapping("/processAddService")
	public String processAddService(com.otu.model.ProvidedService providedService, Model model) {

		System.out.println(providedService);
		
		boolean serviceCreated = service.addService(providedService);
		
		model.addAttribute("serviceAddedSuccessfully", serviceCreated); // boolean for error text in the template
		
//		if(serviceCreated) {
//			model.addAttribute("addedService?????", providedService.get????()); //?
//		}
		
		return "redirect:/services";
	}
	
}
