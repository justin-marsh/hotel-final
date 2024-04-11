package com.otu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.otu.model.Customer;

import com.otu.repository.ServiceRepository;


@Service
public class ProvidedService {
	ServiceRepository repo;

	@Autowired
	public ProvidedService(ServiceRepository repo) {
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
	

	
}