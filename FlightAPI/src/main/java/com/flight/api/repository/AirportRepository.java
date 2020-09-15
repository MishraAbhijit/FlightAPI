package com.flight.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flight.api.entities.Airport;

public interface AirportRepository extends JpaRepository<Airport, String> {

}
