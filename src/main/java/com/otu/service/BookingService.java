package com.otu.service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.otu.model.Booking;
import com.otu.model.Customer;
import com.otu.model.Room;
import com.otu.repository.BookingRepository;
import com.otu.service.CustomerService;

@Service
public class BookingService {
	BookingRepository repo;

	@Autowired
	public BookingService(BookingRepository repo) {
		super();
		this.repo = repo;
	}

	
	public boolean addBooking(Booking booking) {
		
		Room room = booking.getRoom();
		Customer customer = booking.getCustomer();
		List<Booking> existingBookings = repo.findByCustomerAndRoom(customer, room);
		
		if(existingBookings.isEmpty()) {
			System.out.println("NOT EXIST");
			repo.save(booking);
			return true;
		}
		System.out.println("EXIST");
		return false;
	}
	
	public List<Booking> getBookings() {
        return Collections.<Booking>emptyList();
    }
	

	
}