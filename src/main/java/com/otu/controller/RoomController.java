package com.otu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.otu.model.Room;
import com.otu.service.RoomService;

@Controller
public class RoomController {
	RoomService service;
	
	@Autowired
	public RoomController(RoomService service) {
		super();
		this.service = service;
	}

	@GetMapping("/addRoom")
	public String addRoom(Model model) {
		model.addAttribute("room", new Room());
		
		return "rooms";
	}
	
	@PostMapping("/processAddRoom")
	public String processAddRoom(Room room, Model model) {
		
		System.out.println(room);
		//View    Controller    Service      Repository    DB
		boolean RoomCreated = service.addRoom(room);
		
		if(RoomCreated) {
			model.addAttribute("roomNumber", room.getRoomNumber());
			return "book-created";
		} else {
			return "redirect:/addRoom";
		}		
	}
	

}