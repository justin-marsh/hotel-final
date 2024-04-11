package com.otu.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToOne;

@Entity
public class ProvidedService {
	@Id
	@GeneratedValue
	private long id;
	private String name;
	private String description;
	private double price;

	@ManyToOne
	@JoinTable(name = "bookings_services", joinColumns = { @JoinColumn(name = "service_id") }, inverseJoinColumns = {
            @JoinColumn(name = "booking_id") })
	private Booking booking;
	
	public ProvidedService() {
		super();
	}

	public ProvidedService(long id, String name, String description, double price, Booking booking) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.booking = booking;

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	public Booking getBooking() {
		return this.booking;
	}
	
	public void setBooking(Booking booking) {
		this.booking = booking;
	}

	@Override
	public String toString() {
		return "ProvidedService [id=" + id + ", name=" + name + ", description=" + description + ", price=" + price
				+ "]";
	}
	
	public String toDropDown() {
		return this.name + " " + this.description + " $" + this.price;
	}
}