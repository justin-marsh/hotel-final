package com.otu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.otu.model.ProvidedService;
import com.otu.model.Room;

public interface ServiceRepository extends JpaRepository<ProvidedService, Long>{
	
	boolean existsById(long id);
	
	
	@Query("select s from ProvidedService s where upper(s.name) like concat('%', upper(:name), '%')")
	List<ProvidedService> findByName(@Param("name") String name);
	
	@Query("select s from ProvidedService s where s.id = :id")
	List<ProvidedService> findById(@Param("id") long id);
	
}
