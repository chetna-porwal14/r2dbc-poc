package com.example.R2DBCpoc;

import java.util.UUID;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface LivestockRepository extends ReactiveCrudRepository<Livestock, UUID>{

	

}
