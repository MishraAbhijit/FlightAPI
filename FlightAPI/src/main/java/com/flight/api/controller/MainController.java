package com.flight.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flight.api.entities.FilghtCompleteInfo;
import com.flight.api.entities.Flight;
import com.flight.api.services.FlightCompleteInfoService;

@RestController
@RequestMapping("/userInfo")
@CrossOrigin
public class MainController {

	@Autowired
	private FlightCompleteInfoService flightCompleteInfoService;
	
	//get required Info
	@GetMapping("/{src}/{dst}")
	public FilghtCompleteInfo getUserRequiredInfo(@PathVariable("src") String source,@PathVariable("dst") String destination)
	{
		System.out.println("Inside complete Info ...............");
		FilghtCompleteInfo completeInfo = flightCompleteInfoService.getCompleteInfo(source,destination);
		System.out.println(completeInfo);
		return completeInfo;
	}
	
	//get Flight Info
	@GetMapping("/flight/{id}")
	public Flight getFlightInfo(@PathVariable("id") String id)
	{
		Flight flight = flightCompleteInfoService.getFlightInfo(id);
		System.out.println(flight);
		return flight;
	}
}
