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

	@GetMapping("/rooms")
	public String rooms(Model model) {
		model.addAttribute("room", new Room()); // empty obj for filling with data to add a new obj to repo
		model.addAttribute("existingRooms", service.getRooms()); // list<Obj> of all objs in the repo
		
		return "rooms";
	}
	
	@PostMapping("/processAddRoom")
	public String processAddRoom(Room room, Model model) {

		System.out.println(room);
		
		boolean roomCreated = service.addRoom(room);
		
		model.addAttribute("roomAddedSuccessfully", roomCreated); // boolean for error text in the template
		
		if(roomCreated) {
			model.addAttribute("addedRoomNumber", room.getRoomNumber());
		}
		
		return "redirect:/rooms";
	}
	

}