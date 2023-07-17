package com.example.femida_v4;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class FemidaV4Application
{
	
	public static void main(String[] args)
	{
		log.info("--------------------------------------------------------------------------------------------------------");
		SpringApplication.run(FemidaV4Application.class, args);
	}
	
}
