package com.flight.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flight.api.entities.Flight;
import com.flight.api.services.FlightService;

@RestController
@RequestMapping("/flights")
public class FlightController {

	@Autowired
	private FlightService flightService;
	
	@GetMapping("/")
	public List<Flight> getAllFlights()
	{
		List<Flight> allFlights = flightService.getAllFlights();
		return allFlights;
	}
	
	@GetMapping("/{id}/")
	public Flight getFlight(@PathVariable String id)
	{
		Flight flightById = flightService.getFlightById(id);
		return flightById;
	}
	
	@GetMapping("/root/{rootCode}/")
	public List<Flight> getFlightsByRoot(@PathVariable String rootCode)
	{
		List<Flight> flightsByRoot = flightService.getFlightsByRoot(rootCode);
		return flightsByRoot;
	}
	
	@PostMapping("/add/")
	public Flight addFlight(@RequestBody Flight flight)
	{
		Flight newFlight = flightService.addOrupdateFlight(flight);
		return newFlight;
	}
	
	@PutMapping("/update/")
	public Flight updateFlight(@RequestBody Flight flight)
	{
		Flight updatedFlight = flightService.addOrupdateFlight(flight);
		return updatedFlight;
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteFlight(@PathVariable String id)
	{
		flightService.deleteFlight(id);
		return "Deleted";
	}
}
