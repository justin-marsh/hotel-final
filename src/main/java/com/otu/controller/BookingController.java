package com.otu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.otu.model.Booking;
import com.otu.model.Customer;
import com.otu.model.Room;
import com.otu.service.BookingService;
import com.otu.service.CustomerService;

import com.otu.service.RoomService;

@Controller
public class BookingController {
	BookingService service;
	CustomerService customerService;
	RoomService roomService;
	
	@Autowired
	public BookingController(BookingService service, CustomerService customerService, RoomService roomService) {
		super();
		this.service = service;
		this.customerService = customerService;
		this.roomService = roomService;
	
	}
	
	// from /rooms form
	@PostMapping("/bookFromRoom")
	public String bookFromRoom(Room room, Model model) {
		
		Booking booking = new Booking();
		booking.setRoom(room);	
		model.addAttribute("booking", booking);
		
		return this.bookings_finishPage(model);
	}
	
	// from /customers form
	@PostMapping("/bookFromCustomer")
	public String bookFromCustomer(Customer customer, Model model) {
		
		Booking booking = new Booking();
		booking.setCustomer(customer);	
		model.addAttribute("booking", booking);
		
		return this.bookings_finishPage(model);
	}

	@GetMapping("/bookings")
	public String bookings(Model model) {  
		model.addAttribute("booking", new Booking()); // empty obj for filling with data to add a new obj to repo
		return this.bookings_finishPage(model);
	}
	
	@PostMapping("/bookings")
	public String bookings(Booking booking, Model model) {
		
		service.fillOutFields(booking);
		
		boolean bookingCreated = service.addBooking(booking);
		
		if(bookingCreated) {
			model.addAttribute("addedBookingId", booking.getId());
			return this.bookings(model);
		} else {
			model.addAttribute("errorText", "Failed to add booking");
			model.addAttribute("booking", booking); // empty obj for filling with data to add a new obj to repo
			return this.bookings_finishPage(model);
		}
	}


	public String bookings_finishPage(Model model){
		model.addAttribute("existingBookings", service.getBookings()); // list<Obj> of all objs in the repo
		model.addAttribute("CustomerDropdown", customerService.getDropDown()); // list<CustomerDropdowns> for use in drop downs
		model.addAttribute("existingRooms", roomService.getRooms()); // list<Obj> of all objs in the repo
		
		return "bookings";
	}
	
}
