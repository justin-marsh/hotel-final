package com.otu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.otu.model.Booking;
import com.otu.model.Customer;
import com.otu.model.ProvidedService;
import com.otu.model.Room;

public interface BookingRepository extends JpaRepository<Booking, Long>{
	
	//boolean existsByIdAndName(Long id, String name);
	boolean existsByRoomId(Long roomId);
	
	boolean existsById(Long id);
	
	@Query("select b from Booking b where b.room = :room")
	List<Booking> findByRoom(@Param("room") Room room);
	
	@Query("select b from Booking b where b.customer = :customer and b.room = :room")
	List<Booking> findByCustomerAndRoom(@Param ("customer") Customer customer, @Param("room") Room room);
	
	@Query("select b from Booking b where b.id = :id")
	List<Booking> findById(@Param("id") long id);
}
