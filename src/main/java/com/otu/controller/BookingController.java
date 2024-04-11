package com.otu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.otu.model.Booking;
import com.otu.service.BookingService;
import com.otu.service.CustomerService;

@Controller
public class BookingController {
	BookingService service;
	
	@Autowired
	public BookingController(BookingService service) {
		super();
		this.service = service;
	
	}

	@GetMapping("/bookings")
	public String bookings(Model model) {
		model.addAttribute("booking", new Booking()); // empty obj for filling with data to add a new obj to repo
		model.addAttribute("existingBookings", service.getBookings()); // list<Obj> of all objs in the repo
		
		return "bookings";
	}
	
	@PostMapping("/processAddBooking")
	public String processAddBooking(Booking booking, Model model) {

		System.out.println(booking);
		
		boolean bookingCreated = service.addBooking(booking);
		
		model.addAttribute("bookingAddedSuccessfully", bookingCreated); // boolean for error text in the template
		
//		if(bookingCreated) {
//			model.addAttribute("addedBooking?????", booking.get????()); //?
//		}
		
		return "redirect:/bookings";
	}


	// from /rooms form
	@PostMapping("/bookFromRoom")
	public String bookThisRoom(Room room, Model model) {
		
		// from the rooms page, this is the room to be booked
		
		return this.bookings(model);
	}
	
}
