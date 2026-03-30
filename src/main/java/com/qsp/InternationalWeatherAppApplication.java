package com.qsp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.qsp.service.WeatherService;
import com.qsp.serviceimplement.WeatherServiceImplementation;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;

@SpringBootApplication
@OpenAPIDefinition
public class InternationalWeatherAppApplication {
	public static void main(String[] args) {
		ConfigurableApplicationContext run = 
			SpringApplication.run(InternationalWeatherAppApplication.class, args) ;
//	WeatherService s= run.getBean(WeatherServiceImplementation.class);
//	System.out.println(s.getSingleWeather("delhi"));
	}
}
