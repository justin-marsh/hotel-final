package com.otu.service;

import java.time.Month;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.otu.model.Customer;
import com.otu.model.ProvidedService;
import com.otu.repository.ServiceRepository;


@Service
public class ProvidedServiceService {
	ServiceRepository repo;

	@Autowired
	public ProvidedServiceService(ServiceRepository repo) {
		super();
		this.repo = repo;
	}

	
	public boolean addService(ProvidedService providedService) {
		if(!repo.existsById(providedService.getId())) {
			System.out.println("creating Service in db");
			repo.save(providedService);
			return true;
		}
		System.out.println("Service cant be created");
		return false;
	}
	
	public List<ProvidedService> getProvidedServices() {
		com.otu.model.Room tempRoom = new com.otu.model.Room(1000l, 303, "suite", 50.00);
		com.otu.model.Customer tempCustomer = new com.otu.model.Customer(1000l, "Lexa Valentine", "435-4444 pizza nova!", "justin.trudeau@canada.gov");
		java.time.LocalDate tempStartDate = java.time.LocalDate.now(); 
		java.time.LocalDate tempEndDate = java.time.LocalDate.of(2025, java.time.Month.JANUARY, 1);
		com.otu.model.Booking tempBooking = new com.otu.model.Booking(1000l, tempCustomer, tempRoom, tempStartDate, tempEndDate);
		return java.util.Arrays.asList(
			new ProvidedService(1, "Mini bar", "1 bottle of Jack Daniels", 9999.99, tempBooking),
			new ProvidedService(2, "Room service", "Cleaning", 10.00, tempBooking),
			new ProvidedService(3, "Pay Per View", "NBA, NHL, NFL", 33.00, tempBooking)
		);
//		return repo.findAll();
    }
	
	public boolean validateService(ProvidedService service) {
		return repo.existsById(service.getId());
	}

	
}
