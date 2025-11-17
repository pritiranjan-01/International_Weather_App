package com.qsp.runner;

import java.util.Map;
import java.util.Random;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.qsp.dto.WeatherDTO;
import com.qsp.util.InternationalCity;
import com.qsp.util.WeatherType;

@Component
public class PrepareDataRunner implements CommandLineRunner{
	
	@Autowired
	private Random random;
	
	@Autowired // Inject object from configuration and initialize by this class run method.
	@Qualifier("internationalWeather")
	private Map<String, WeatherDTO> internationalWeather;
	
	Set<String> cities = InternationalCity.getCities();

	@Override
	public void run(String... args) throws Exception {
		for(String city: cities) {
			WeatherDTO tempWeather = WeatherDTO.builder()
					                .temperature(random.nextInt(16,40))
					                .type(WeatherType.getWeatherType(random.nextInt(0,9)))
					                .build();
			internationalWeather.put(city, tempWeather);
		}
	}
}
