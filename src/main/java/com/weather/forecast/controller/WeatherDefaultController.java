/**
 * 
 */
package com.weather.forecast.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.weather.forecast.beans.DefaultProperties;
import com.weather.forecast.beans.WeatherDetails;
import com.weather.forecast.services.WeatherForecastService;

/**
 * @author anandsingh
 *
 */
@RestController
@RequestMapping("/")
public class WeatherDefaultController {
	
	@Autowired
	private WeatherForecastService weatherForecastService;
	
	@Autowired
	private DefaultProperties defaultProperties;
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView getWeatherForecastDefault()
	{
		List<WeatherDetails> defaultWeatherList =  new ArrayList<WeatherDetails>();
		defaultWeatherList = weatherForecastService.getDefaultWeatherForecast(defaultProperties.getDefaultLocations());
		ModelAndView model = new ModelAndView("homePage");
		model.addObject("defaultWeatherList", defaultWeatherList);
		return model;
	}
	
	@RequestMapping(method=RequestMethod.POST,path="/search")
	public ModelAndView getWeatherForCity(@RequestParam String cityName, @RequestParam String countryName)
	{
		WeatherDetails weatherDetails = weatherForecastService.getWeatherDetailsForCity(cityName, countryName);
		List<WeatherDetails> defaultWeatherList =  new ArrayList<WeatherDetails>();
		defaultWeatherList.add(weatherDetails);
		ModelAndView model = new ModelAndView("homePage");
		model.addObject("defaultWeatherList", defaultWeatherList);
		return model;
	}

}
