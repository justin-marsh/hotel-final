package com.otu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.otu.model.Booking;
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

	
//	public boolean addBooking(Booking booking) {
//		if(!repo.existsByRoomId(booking.getRoomId()) && CustomerService.validCustomer(booking.getCustomerId()) && RoomService.validRoom(booking.getRoomId())) {
//			System.out.println("NOT EXIST");
//			repo.save(booking);
//			return true;
//		}
//		System.out.println("EXIST");
//		return false;
//	}
	

	
}