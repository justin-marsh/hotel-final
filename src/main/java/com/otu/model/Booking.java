package com.otu.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import java.time.LocalDate;

@Entity
public class Booking {
	@Id
	@GeneratedValue
	private long id;
	private Customer customer;
	private Room room;
	private LocalDate startDate;
	private LocalDate endDate;
	
	
	
	public Booking() {
		super();
	}

	public Booking(long id, Customer customer, Room room, LocalDate startDate, LocalDate endDate) {
		super();
		this.id = id;
		this.customer = customer;
		this.room = room;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	@Override
	public String toString() {
		return "Booking [id=" + id + ", customerId=" + customer.getId() + ", roomId=" + room.getId() + ", startDate=" + startDate
				+ ", endDate=" + endDate + "]";
	}
	
}