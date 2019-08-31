/**
 * 
 */
package com.weather.forecast.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.weather.forecast.entity.WeatherForeCastEntity;

/**
 * @author anandsingh
 *
 */
public interface WeatherForecastRepository extends MongoRepository<WeatherForeCastEntity, String> {
	
	
	WeatherForeCastEntity findBycityNameAndCountryName(String cityName, String CountryName);

}
