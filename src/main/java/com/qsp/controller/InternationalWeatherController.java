package com.qsp.controller;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.qsp.dto.ResponseStructure;
import com.qsp.dto.WeatherDTO;
import com.qsp.modelmapper.ResponseEntityMapper;
import com.qsp.modelmapper.ResponseStructureModelMapper;
import com.qsp.service.WeatherService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/InternationalWeather")
@Tag(name = "/weather", description = "View all and single Weather")
public class InternationalWeatherController {
	
	@Autowired
	private WeatherService weatherService;
	
	@Autowired
	private ResponseStructureModelMapper structureMapper;
	
	@Autowired
	private ResponseEntityMapper mapper;

	@GetMapping("/{city}")
	@Operation(summary = "Get Single international weather by City Name")
	public ResponseEntity<ResponseStructure<WeatherDTO>> 
								getWeatherByCity(@PathVariable String city){
		WeatherDTO dto = weatherService.getSingleWeather(city);
		ResponseStructure<WeatherDTO> structure =  structureMapper
				.mapToResponseStructure(HttpStatus.OK, "Object", dto);
		return mapper.getResponseEntity(structure,HttpStatus.OK);
	}
	
	@GetMapping
	@Operation(summary = "Get all international weather")
	public ResponseEntity<ResponseStructure<Map<String, WeatherDTO>>> getAllWeather(){
		Map<String, WeatherDTO> map = weatherService.getAllInternationalWeather();
		ResponseStructure<Map<String, WeatherDTO>> structure = structureMapper
				.mapToResponseStructure(HttpStatus.OK, "Object", map);
		return mapper.getResponseEntity(structure, HttpStatus.OK);
	}
}
