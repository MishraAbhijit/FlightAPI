package com.flight.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flight.api.entities.RootMap;

public interface RootMapRepository extends JpaRepository<RootMap, Integer> {

	RootMap findByDayAndSourceAndDestination(String day, String Source, String Destination);
}
