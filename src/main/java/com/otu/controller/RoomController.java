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
		return this.rooms_finishPage(model);
	}	
	
	@PostMapping("/rooms") // Doing this so that the posted form has a nice neat URL
	public String rooms(Room room, Model model) {

		boolean roomCreated = service.addRoom(room);		
		
		if(roomCreated) {
			model.addAttribute("addedRoomNumber", room.getRoomNumber());
			return this.rooms(model); // setup the rooms page
		} else {
			model.addAttribute("errorText", "Failed to add room");
			model.addAttribute("room", room); // empty obj for filling with data to add a new obj to repo
			return this.rooms_finishPage(model); // setup the rooms page
		}
		
	}
	

	public String rooms_finishPage(Model model){
		model.addAttribute("existingRooms", service.getRooms()); // list<Obj> of all objs in the repo
		
		return "rooms";
	}
}