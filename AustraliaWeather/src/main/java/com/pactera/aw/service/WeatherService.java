package com.pactera.aw.service;

import com.pactera.aw.model.Weather;

public interface WeatherService<T> {

	public Weather getWeatherData(T t);
}
