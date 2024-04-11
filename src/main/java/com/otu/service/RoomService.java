package com.otu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.otu.model.Room;
import com.otu.repository.RoomRepository;


@Service
public class RoomService {
	RoomRepository repo;

	@Autowired
	public RoomService(RoomRepository repo) {
		super();
		this.repo = repo;
	}

	
	public boolean addRoom(Room room) {
		if(!repo.existsById(room.getId())) {
			System.out.println("creating room");
			repo.save(room);
			return true;
		}
		System.out.println("room cant be created");
		return false;
	}
	
	public List<Room> getRooms(){
		return Arrays.asList(
			new Room(1, 1, "Suite", 69.99),
			new Room(2, 2, "Suite", 70.01),
			new Room(3, 3, "Penthouse", 420.00)
		);
	}

	
}
