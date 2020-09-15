package com.flight.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flight.api.entities.Airport;
import com.flight.api.entities.FilghtCompleteInfo;
import com.flight.api.entities.Flight;
import com.flight.api.entities.RootMap;

@Service
public class FlightCompleteInfoService {

	@Autowired
	private FlightService flightService;
	@Autowired
	private AirportService airportService;
	@Autowired
	private RootMapService rootMapService;
	@Autowired
	private FilghtCompleteInfo completeInfo;
	
	public FilghtCompleteInfo getCompleteInfo(String src,String dst)
	{
		System.out.println("Flight Complete Info Source: "+src+" Destination: "+dst);
		String sourceCode=rootMapService.rootCodeConverter(src);
		String destinationCode=rootMapService.rootCodeConverter(dst);
		System.out.println("Flight Complete Info Source Code: "+sourceCode+" Destination Code: "+destinationCode);
		RootMap root = rootMapService.getParticularRoot("Daily", sourceCode, destinationCode);
		List<Flight> flightsByRoot = flightService.getFlightsByRoot(root.getUniqueCode());
		Airport source = airportService.findAirport(sourceCode);
		Airport destination = airportService.findAirport(destinationCode);
		
		completeInfo.setFlight(flightsByRoot);
		completeInfo.setSource(source);
		completeInfo.setDestination(destination);
		return completeInfo;
	}
	
	public Flight getFlightInfo(String id)
	{
		Flight flight = flightService.getFlightById(id);
		return flight;
	}
}
