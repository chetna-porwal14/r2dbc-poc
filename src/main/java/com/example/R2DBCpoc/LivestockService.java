package com.example.R2DBCpoc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class LivestockService {
	
	@Autowired
	private LivestockRepository livestockRepository;
	
	public Flux<Livestock> getAll() {
		return livestockRepository.findAll();
	}

	public Flux<Livestock> save(Flux<Livestock> l) {
		return l.flatMap(livestockRepository::save);
	}

}