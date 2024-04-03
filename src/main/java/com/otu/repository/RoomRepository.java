package com.otu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.otu.model.Room;

public interface RoomRepository extends JpaRepository<Room, Long>{
	
	boolean existsById(Long id);
	
	@Query("select r from Room r where r.roomNumber = :roomNumber")
	List<Room> findByroomNumber(@Param("roomNumber") int roomNumber);
	
}
