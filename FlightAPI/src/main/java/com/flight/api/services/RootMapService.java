package com.flight.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flight.api.entities.RootMap;
import com.flight.api.repository.RootMapRepository;

@Service
public class RootMapService {

	@Autowired
	RootMapRepository rootMapRepository;
	
	public List<RootMap> getAllRoots()
	{
		System.out.println("Inside RootMap Service.............");
		List<RootMap> allRoot = rootMapRepository.findAll();
		return allRoot;
	}
	
	public RootMap getParticularRoot(String day,String source,String destination)
	{
		RootMap particularRoot = rootMapRepository.findByDayAndSourceAndDestination(day, source, destination);
		return particularRoot;
	}
	
	public RootMap updateRoot(RootMap rootMap)
	{
		RootMap save = rootMapRepository.save(rootMap);
		return save;
	}
	
	public String rootCodeConverter(String rootName)
	{
		String rootCode=null;
		if(rootName.equalsIgnoreCase("Bhubaneswar"))
		{
			rootCode="BBS";
		}
		else if(rootName.equalsIgnoreCase("Hyderabad"))
		{
			rootCode="HYD";
		}
		else if(rootName.equalsIgnoreCase("Mumbai"))
		{
			rootCode="BOM";
		}
		else
		{
			rootCode="DEL";
		}
		return rootCode;
	}
}
