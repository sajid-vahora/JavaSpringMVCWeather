package com.pactera.aw.component;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.pactera.aw.model.owm.OpenWeather;

@Component
@PropertySource(value = { "classpath:openweather.properties" })
public class OpenWeatherAPI  {
	
	public final Log logger = LogFactory.getLog(OpenWeatherAPI.class) ;
	
	@Autowired
	private Environment environment;
	
	@Autowired
	private RestTemplate restTemplate; 
	
	
	public OpenWeather getData(String cityName){
		try {
			Map<String, String> map = new HashMap<>();
			map.put("q", cityName);
			map.put("APPID", environment.getProperty("key"));
			OpenWeather openWeather = restTemplate.getForObject(environment.getProperty("url"),OpenWeather.class, map);
			return openWeather;
		} catch(Exception e){
			logger.error("Error while fetching data from OpenWeather for city " + cityName, e);
			return null;
		}
	}
	
	
	
}
