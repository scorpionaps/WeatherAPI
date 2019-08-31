/**
 * 
 */
package com.weather.forecast.services;

import java.util.List;

import com.weather.forecast.beans.WeatherDetails;

/**
 * @author anandsingh
 *
 */
public interface WeatherForecastService {

	List<WeatherDetails> getDefaultWeatherForecast(String defaultLocations);
	
	WeatherDetails getWeatherDetailsForCity(String cityName, String countryName);

}
