package com.qsp.service;

import java.util.Map;

import com.qsp.dto.WeatherDTO;

public interface WeatherService {
	WeatherDTO getSingleWeather(String city);
	Map<String, WeatherDTO> getAllInternationalWeather();
}
