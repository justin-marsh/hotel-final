package com.otu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.otu.model.Booking;

public interface BookingRepository extends JpaRepository<Booking, Long>{
	
	//boolean existsByIdAndName(Long id, String name);
	boolean existsByCustomerIdAndRoomId(Long customerId, Long roomId);

	@Query("select b from Booking b where b.customerId = :customerId and b.roomId = :roomId")
	List<Booking> findByCustomerIdAndRoomId(@Param ("customerId") Long customerId, @Param("roomId") Long roomId);
}
