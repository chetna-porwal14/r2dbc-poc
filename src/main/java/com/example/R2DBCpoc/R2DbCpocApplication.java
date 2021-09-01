package com.example.R2DBCpoc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class R2DbCpocApplication {

	public static void main(String[] args) {
		SpringApplication.run(R2DbCpocApplication.class, args);
	}
	
	//spring r2dbc requires configuration to connect with DB either we can do in application.properties file or exposing connection factory bean
	}
