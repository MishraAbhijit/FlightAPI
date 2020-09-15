package com.flight.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flight.api.entities.Flight;

public interface FlightRepository extends JpaRepository<Flight, String> {

	List<Flight> findByRootCode(String rootCode);
	
}
