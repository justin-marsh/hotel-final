package com.otu.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Room {
	@Id
	@GeneratedValue
	private long id;
	private int roomNumber;
	private String type;
	private double price;
	
	@OneToMany(mappedBy = "room")
	private List<Booking> bookings;

	public Room() {
		super();
	}

	public Room(long id, int roomNumber, String type, double price) {
		super();
		this.id = id;
		this.roomNumber = roomNumber;
		this.type = type;
		this.type = type;
	}


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Room [id=" + id + ", roomNumber=" + roomNumber + ", type=" + type + ", price=" + price + "]";
	}

	public boolean isBooked() {
		// this is essentially random. Just even values are seen as "booked", for variety in style stuff
		return id%2 == 1;
	}
}
