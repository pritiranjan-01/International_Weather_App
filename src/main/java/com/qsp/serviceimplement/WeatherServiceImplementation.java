package com.qsp.serviceimplement;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.qsp.dto.WeatherDTO;
import com.qsp.service.WeatherService;

@Service
public class WeatherServiceImplementation implements WeatherService{
	
	@Autowired
	@Qualifier("internationalWeather")
	private Map<String, WeatherDTO> internationalweather;
	
	public WeatherDTO getSingleWeather(String city) {
		city = city.toUpperCase();
		WeatherDTO response = internationalweather.get(city);
		if(response==null)
			return new WeatherDTO(null,"No weather found for the city");
		return response;
		
	}

	@Override
	public Map<String, WeatherDTO> getAllInternationalWeather() {
		return internationalweather;
	}
}
