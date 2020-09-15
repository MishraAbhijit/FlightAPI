package com.flight.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flight.api.entities.Flight;
import com.flight.api.repository.FlightRepository;

@Service
public class FlightService {

	@Autowired
	private FlightRepository flightRepository;
	
	//get All flight
	public List<Flight> getAllFlights()
	{
		List<Flight> allFlights = flightRepository.findAll();
		return allFlights;
	}
	
	//get FlightById
	public Flight getFlightById(String id)
	{
		Flight flight = flightRepository.findById(id).get();
		return flight;
	}
	
	//get Flight By Route
	public List<Flight> getFlightsByRoot(String rootCode)
	{
		List<Flight> flights = flightRepository.findByRootCode(rootCode);
		return flights;
	}
	
	//add & update flight	
	public Flight addOrupdateFlight(Flight flight)
	{
		Flight newFlight = flightRepository.save(flight);
		return newFlight;
	}
	
	//Delete Flight
	public void deleteFlight(String id)
	{
		flightRepository.deleteById(id);
	}
}
