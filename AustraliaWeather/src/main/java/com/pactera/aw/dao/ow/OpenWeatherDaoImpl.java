package com.pactera.aw.dao.ow;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pactera.aw.component.OpenWeatherAPI;
import com.pactera.aw.dao.WeatherDao;
import com.pactera.aw.exception.DataNotFoundException;
import com.pactera.aw.model.owm.OpenWeather;
import com.pactera.aw.model.owm.OpenWeatherInput;

@Repository
public class OpenWeatherDaoImpl implements WeatherDao<OpenWeather, OpenWeatherInput>{

	@Autowired
	private OpenWeatherAPI openWeatherAPI; 
	
	@Override
	public OpenWeather getData(OpenWeatherInput i) throws DataNotFoundException {
		OpenWeather openWeather = openWeatherAPI.getData(i.getCityName());
		if(openWeather == null){
			throw new DataNotFoundException("Data not found");
		}
		return openWeather;
	}

}
