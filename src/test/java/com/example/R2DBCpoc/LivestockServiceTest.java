package com.example.R2DBCpoc;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

@TestInstance(Lifecycle.PER_CLASS)
public class LivestockServiceTest {

	
	Flux<Livestock> flux;
	@BeforeAll
	void init()
	{
		flux= Flux.just(new Livestock(1, "abc"), 
				new Livestock(2, "abc"), 
				new Livestock(3, "abc"),
				new Livestock(4, "abc"), 
				new Livestock(5, "abc"), 
				new Livestock(6, "abc"), 
				new Livestock(7, "abc"),
				new Livestock(8, "abc"), 
				new Livestock(9, "abc"));
	}
	@Test
	void testFlux1() {

		StepVerifier.create(flux.log())
				.expectNext(new Livestock(1, "abc"))
				.expectNext(new Livestock(2, "abc"))
				.expectNext(new Livestock(3, "abc"))
				.expectNext(new Livestock(4, "abc"));

	}

	@Test
	void testFlux2() {

				StepVerifier.create(flux.log()).expectNextCount(9).verifyComplete();

	}
}