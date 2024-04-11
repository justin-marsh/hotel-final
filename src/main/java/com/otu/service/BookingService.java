package com.otu.service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.otu.model.Booking;
import com.otu.model.Customer;
import com.otu.model.ProvidedService;
import com.otu.model.Room;
import com.otu.repository.BookingRepository;
import com.otu.service.CustomerService;

@Service
public class BookingService {
	BookingRepository repo;
	public CustomerService cService;
	public RoomService rService;
	@Autowired
	public BookingService(BookingRepository repo, CustomerService cService,RoomService rService) {
		super();
		this.repo = repo;
		this.cService = cService;
		this.rService = rService;
	}

	
	public boolean addBooking(Booking booking) {
		
		Room room = booking.getRoom();
		Customer customer = booking.getCustomer();
		List<Booking> existingBookings = repo.findByCustomerAndRoom(customer, room);
		

		if(!cService.validateCustomer(booking.getCustomer())) {
			System.out.println("invalid Customer");
			return false;
		}
		
		if(!rService.validateRoom(booking.getRoom())) {
			System.out.println("Invalid Room");
			return false;
		}
		
		List<Booking> otherBookings = repo.findByRoom(booking.getRoom());
		for(Booking i : otherBookings) {
			if( i.getDatesOverlap(booking)) {
				System.out.println("room not available at listed time!");
				return false;
			}
			
		}
		
		if(existingBookings.isEmpty()) {
			System.out.println("NOT EXIST");
			repo.save(booking);
			return true;
		}
		System.out.println("EXIST");
		return false;
	}
	
	public List<Booking> getBookings() {

		com.otu.model.Room tempRoom = new com.otu.model.Room(1000l, 303, "suite", 50.00);
		com.otu.model.Customer tempCustomer = new com.otu.model.Customer(1000l, "Lexa Valentine", "435-4444 pizza nova!", "justin.trudeau@canada.gov");
		java.time.LocalDate tempStartDate = java.time.LocalDate.now(); 
		java.time.LocalDate tempEndDate = java.time.LocalDate.of(2025, java.time.Month.JANUARY, 1);
		java.time.LocalDate tempStartDate2 = java.time.LocalDate.of(2025, java.time.Month.JANUARY, 2);
		java.time.LocalDate tempEndDate2 = java.time.LocalDate.of(2025, java.time.Month.JANUARY, 1);
		return java.util.Arrays.asList(
				new Booking(1l, tempCustomer, tempRoom, tempStartDate, tempEndDate),
				new Booking(2l, tempCustomer, tempRoom, tempStartDate2, tempEndDate2)
		);
//        return repo.findAll();
    }
	
	public boolean validateBooking(Booking booking) {
		return repo.existsById(booking.getId());
	}

	
}