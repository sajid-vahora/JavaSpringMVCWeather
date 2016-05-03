package com.pactera.aw.component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import com.pactera.aw.model.WeatherInput;

@Component
@PropertySource(value = { "classpath:cities.properties" })
public class CityService {

	@Autowired
	private Environment environment;
	
	private CopyOnWriteArraySet<String> cityCache = new CopyOnWriteArraySet<>();
	
	public WeatherInput getCities(){
		WeatherInput input = new WeatherInput();
		List<String> cityList = new ArrayList<>();;
		if(!cityCache.isEmpty()) {
			cityList.addAll(cityCache);
		}
		input.setCities(cityList);
		return input;
	}
	
	public boolean addCity(String city){
		try {
			cityCache.add(city);
			return true;
		} catch(Exception e) {
			return false;
		}
	}
	
	@PostConstruct
	public void setupCache(){
		String cities = environment.getProperty("cities");
		List<String> cityList = null;
		if(!cities.isEmpty()){
			cityList = Arrays.asList(cities.split(","));
		}
		cityCache.addAll(cityList);
	}
}
