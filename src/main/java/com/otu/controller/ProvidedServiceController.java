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
import com.otu.service.BookingService;

@Controller
public class ProvidedServiceController {
	ProvidedServiceService service;
	BookingService bookingService;
	
	@Autowired
	public ProvidedServiceController(ProvidedServiceService service, BookingService bookingService) {
		super();
		this.service = service;
		this.bookingService = bookingService;
	}

	@GetMapping("/services")
	public String services(Model model) {
		model.addAttribute("service", new ProvidedService()); // empty obj for filling with data to add a new obj to repo
		model.addAttribute("existingServices", service.getProvidedServices()); // list<Obj> of all objs in the repo
		model.addAttribute("existingBookings", bookingService.getBookings()); // list<Obj> of all objs in the repo
		
		return "services";
	}
	
	@PostMapping("/processAddService")
	public String processAddService(ProvidedService providedService, Model model) {

		service.fillOutFields(providedService);
		
		boolean serviceCreated = service.addService(providedService);
		
		model.addAttribute("serviceAddedSuccessfully", serviceCreated); // boolean for error text in the template
		
//		if(serviceCreated) {
//			model.addAttribute("addedService?????", providedService.get????()); //?
//		}
		
		return "redirect:/services";
	}
	
}
