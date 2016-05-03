package com.pactera.aw.component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.pactera.aw.model.owm.OpenWeather;

@Component
@PropertySource(value = { "classpath:openweather.properties" })
public class OpenWeatherAPI  {
	
	public final Log logger = LogFactory.getLog(OpenWeatherAPI.class) ;
	
	@Autowired
	private Environment environment;
	
	
	public OpenWeather getData(String cityName){
		try {
			Map<String, String> map = new HashMap<>();
			map.put("q", cityName);
			map.put("APPID", environment.getProperty("key"));
			RestTemplate restTemplate = new RestTemplate();
			// Add the Jackson and String message converters
			List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();
			messageConverters.add(new FormHttpMessageConverter());
			messageConverters.add(new StringHttpMessageConverter());
			messageConverters.add(new MappingJackson2HttpMessageConverter());
			restTemplate.setMessageConverters(messageConverters);
			OpenWeather openWeather = restTemplate.getForObject(environment.getProperty("url"),OpenWeather.class, map);
			return openWeather;
		} catch(Exception e){
			logger.error("Error while fetching data from OpenWeather for city " + cityName, e);
			return null;
		}
	}
	
	
	
}
