package com.flight.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flight.api.entities.Airport;
import com.flight.api.repository.AirportRepository;

@Service
public class AirportService {

	@Autowired
	AirportRepository airportRepository;
	
	public List<Airport> findAllAirport()
	{
	  List<Airport> airports = airportRepository.findAll();
	  return airports;
	}
	
	public Airport findAirport(String code)
	{
		Airport airport = airportRepository.findById(code).get();
		return airport;
	}
	
	public Airport saveOrupdateAirport(Airport airport)
	{
		Airport savedAirport = airportRepository.save(airport);
		return savedAirport;
	}
}
