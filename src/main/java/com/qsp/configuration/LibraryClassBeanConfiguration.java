package com.qsp.configuration;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.qsp.dto.WeatherDTO;

@Configuration
public class LibraryClassBeanConfiguration {
	
	@Bean
	Random createRandomObject() {
		return new Random();
	}
	
	@Bean("internationalWeather")
	Map<String, WeatherDTO> createInternationalWeatherData(){
		return new LinkedHashMap<String, WeatherDTO>();
	}
}
