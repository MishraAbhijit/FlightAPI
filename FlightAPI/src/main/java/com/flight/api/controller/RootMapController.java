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

import com.flight.api.entities.RootMap;
import com.flight.api.services.RootMapService;

@RestController
@RequestMapping("/roots")
public class RootMapController {

	@Autowired
	RootMapService rootMapService;
	
	//fetch all roots
	@GetMapping("/all/")
	public List<RootMap> getAllRoots()
	{
		System.out.println("Inside RootMap Controller............");
		List<RootMap> allRoots = rootMapService.getAllRoots();
		for (RootMap root : allRoots) {
			System.out.println(root);
		}
		return allRoots;
	}
	
	//fetch particular root
	@GetMapping("/{day}/{source}/{destination}")
	public RootMap getParticularRoot(@PathVariable String day,@PathVariable String source ,@PathVariable String destination)
	{
	
		System.out.println("Inside get Particular Rppt Controller ...............");
		System.out.println("Day: "+ day +"Source: "+source+"Destination: "+destination);
		RootMap particularRoot = rootMapService.getParticularRoot(day, source, destination);
		return particularRoot;
	}
	
	//create root
	@PostMapping("/create/")
	public RootMap createRoot(@RequestBody RootMap rootMap)
	{
		System.out.println("Create Root Controller.............");
		RootMap createRootMap = rootMapService.updateRoot(rootMap);
		System.out.println(createRootMap);
		return createRootMap;
	}
	
	//update root
	@PutMapping("/update/")
	public RootMap updateRoot(@RequestBody RootMap rootMap)
	{
		System.out.println("Update Root Controller.............");
		RootMap updateRootMap = rootMapService.updateRoot(rootMap);
		System.out.println(updateRootMap);
		return updateRootMap;
	}
}
