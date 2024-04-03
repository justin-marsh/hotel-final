package com.otu.repository;
/*
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.otu.model.ProvidedService;

public interface ServiceRespository extends JpaRepository<ProvidedService, Long>{
	
	boolean existsByNameAndDescription(String name, String description);
	
	
	@Query("select s from Service s where upper(s.name) like concat('%', upper(:name), '%')")
	List<ProvidedService> findByName(@Param("name") String name);
	
}
*/