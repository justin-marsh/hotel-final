package com.otu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.otu.model.Booking;
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

	@GetMapping("/bookings")
	public String bookings(Model model) {
	   
		model.addAttribute("booking", new Booking()); // empty obj for filling with data to add a new obj to repo
		model.addAttribute("existingBookings", service.getBookings()); // list<Obj> of all objs in the repo
		
		//List<CustomerDropdown> temp = service.cService.getDropDown();
		
		
		model.addAttribute("CustomerDropdown", customerService.getDropDown()); // list<CustomerDropdowns> for use in drop downs
		model.addAttribute("existingRooms", roomService.getRooms()); // list<Obj> of all objs in the repo
		
		
		return "bookings";
	}
	
	@PostMapping("/bookings")
	public String bookings(Booking booking, Model model) {
		
		service.fillOutFields(booking);
		
		boolean bookingCreated = false;
//		boolean bookingCreated = service.addBooking(booking);
		
		model.addAttribute("bookingAddedSuccessfully", bookingCreated); // boolean for error text in the template
		
//		if(bookingCreated) {
//			model.addAttribute("addedBooking?????", booking.get????()); //?
//		}
		
		return this.bookings(model);
	}


	// from /rooms form
	@PostMapping("/bookFromRoom")
	public String bookThisRoom(Room room, Model model) {
		
		// from the rooms page, this is the room to be booked
		
		return this.bookings(model);
	}
	
}
