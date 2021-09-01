package com.example.R2DBCpoc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/livestock")
public class LivestockController {

	@Autowired
	private LivestockService livestockService;
	
	@GetMapping("/getAll")
	public Flux<Livestock> getAll()
	{
		return livestockService.getAll();
	}
	
	@PostMapping("/save")
	public Flux<Livestock> saveAll(@RequestBody Flux<Livestock> l)
	{
		return livestockService.save(l);
	}
}