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
	private long customerId;
	private long roomId;
	private LocalDate startDate;
	private LocalDate endDate;
	

	public Booking() {
		super();
	}

	public Booking(long id, long customerId, long roomId, LocalDate startDate, LocalDate endDate) {
		super();
		this.id = id;
		this.customerId = customerId;
		this.roomId = roomId;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public long getRoomId() {
		return roomId;
	}

	public void setRoomId(long roomId) {
		this.roomId = roomId;
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
		return "Booking [id=" + id + ", customerId=" + customerId + ", roomId=" + roomId + ", startDate=" + startDate
				+ ", endDate=" + endDate + "]";
	}
	
}