package com.otu.service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.otu.model.Customer;

import com.otu.repository.ServiceRepository;


@Service
public class ProvidedServiceService {
	ServiceRepository repo;

	@Autowired
	public ProvidedServiceService(ServiceRepository repo) {
		super();
		this.repo = repo;
	}

	
	public boolean addService(com.otu.model.ProvidedService providedService) {
		if(!repo.existsById(providedService.getId())) {
			System.out.println("creating Service in db");
			repo.save(providedService);
			return true;
		}
		System.out.println("Service cant be created");
		return false;
	}
	
	public List<com.otu.model.ProvidedService> getProvidedServices() {
        //return Collections.<com.otu.model.ProvidedService>emptyList();
		return repo.findAll();
    }
	
	public boolean validateService(com.otu.model.ProvidedService service) {
		return repo.existsById(service.getId());
	}

	
}
