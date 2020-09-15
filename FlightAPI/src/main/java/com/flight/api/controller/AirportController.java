package com.flight.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flight.api.entities.Airport;
import com.flight.api.services.AirportService;

@RestController
@RequestMapping("/airport")
public class AirportController {

	@Autowired
	private AirportService airportService;
	
	//find all airport
	@GetMapping("/all/")
	public List<Airport> findAllAirport()
	{
		System.out.println("Find All Airports Controller ..........");
		List<Airport> airports = airportService.findAllAirport();
		return airports;
	}
	
	//find particular airport
	@GetMapping("/{code}/")
	public Airport findAirport(@PathVariable String code)
	{
		Airport airport = airportService.findAirport(code);
		return airport;
	}
	
	//create Airport
	@PostMapping("/create/")
	public Airport createAirport(@RequestBody Airport airport)
	{
		Airport newAirport = airportService.saveOrupdateAirport(airport);
		return newAirport;
	}
	
	//update Airport
	@PutMapping("/update/")
	public Airport updateAirport(@RequestBody Airport airport)
	{
		Airport newAirport = airportService.saveOrupdateAirport(airport);
		return newAirport;
	}
}
