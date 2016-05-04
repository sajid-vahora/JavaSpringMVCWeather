package com.pactera.aw.component;

import java.util.ArrayList;
import java.util.List;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.client.RestTemplate;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pactera.aw.model.owm.OpenWeather;
import com.pactera.aw.model.owm.OpenWeatherInput;
import com.pactera.aw.model.owm.OpenWeatherMain;
import com.pactera.aw.model.owm.OpenWeatherWeather;
import com.pactera.aw.model.owm.OpenWeatherWind;


public class OpenWeatherAPITest {
	
	@InjectMocks
	private OpenWeatherAPI openWeatherAPI;
	
	@Mock
	private RestTemplate restTemplate;
	
	@Mock
	private Environment environment;
	
	private OpenWeather openWeather;

	@BeforeMethod
	public void beforeMethod() {
		
		MockitoAnnotations.initMocks(this);
		
		openWeather = new OpenWeather();
		OpenWeatherInput openWeatherInput = new OpenWeatherInput();
		OpenWeatherMain main = new OpenWeatherMain();
		OpenWeatherWind wind = new OpenWeatherWind();
		OpenWeatherWeather weather = new OpenWeatherWeather();
		List<OpenWeatherWeather> list = new ArrayList<OpenWeatherWeather>();
		list.add(weather);
		openWeatherInput.setCityName("Sydney");
		main.setTemp("250");
		wind.setSpeed("4");
		weather.setDescription("Cloudy");
		openWeather.setDt("45689555");
		openWeather.setMain(main);
		openWeather.setWind(wind);
		openWeather.setWeather(list);

	}

	@Test
	public void getData() {
		Mockito.when(restTemplate.getForObject(Mockito.anyString(),Mockito.any(), Mockito.anyMapOf(String.class, String.class))).thenReturn(openWeather);
		Mockito.when(environment.getProperty(Mockito.anyString())).thenReturn("");
		OpenWeather openWeather = openWeatherAPI.getData("Sydney");
		Assert.assertEquals(openWeather.getDt(), this.openWeather.getDt());
		Assert.assertEquals(openWeather.getMain().getTemp(), this.openWeather.getMain().getTemp());
		Assert.assertEquals(openWeather.getWeather().get(0).getDescription(), this.openWeather.getWeather().get(0).getDescription());
		Assert.assertEquals(openWeather.getWind(), this.openWeather.getWind());
	}
	
}
