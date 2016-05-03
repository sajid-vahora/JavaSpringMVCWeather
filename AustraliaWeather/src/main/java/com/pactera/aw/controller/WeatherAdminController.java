package com.pactera.aw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.pactera.aw.component.CityService;

@Controller
@RequestMapping(value="admin")
public class WeatherAdminController {

	@Autowired
	private CityService cityService;
	
	@RequestMapping(value="addCity", method=RequestMethod.POST)
	public  ModelAndView addCRequity(@RequestParam("city") String city){
		String msg = "";
		if(cityService.addCity(city)){
			msg =  city + "added successfully"; 
		} else {
			msg = city + " can't added now. Please retry again";
		}
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("message", msg);
		modelAndView.setViewName("weatherAdmin");
		return modelAndView;
	}
	
	@RequestMapping(value="", method=RequestMethod.GET)
	public String getAdminHomePage(){
		return "weatherAdmin";
	}
}
