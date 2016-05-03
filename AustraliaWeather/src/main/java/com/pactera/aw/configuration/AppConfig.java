package com.pactera.aw.configuration;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

/*@Configuration
@ComponentScan(basePackages = { "com.pactera.aw.service", "com.pactera.aw.dao", "com.pactera.aw..component", 
		"com.pactera.aw.configuration" })
@PropertySource(value = { "classpath:openweather.properties" })
public class AppConfig {

	@Autowired
	private Environment environment;
	
	@Bean
	public Map<String, String> openWeatherConnection(){
		Map<String, String> map = new HashMap<>();
		map.put("url", environment.getProperty("url"));
		map.put("key", environment.getProperty("key"));
		return map;
	}

	
}*/
