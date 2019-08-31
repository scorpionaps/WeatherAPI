/**
 * 
 */
package com.weather.forecast.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.weather.forecast.entity.WeatherForecastEntity;

/**
 * @author anandsingh
 *
 */
@Repository
public interface WeatherForecastRepository extends MongoRepository<WeatherForecastEntity, String> {
	
	
	WeatherForecastEntity findBycityNameAndCountryName(String cityName, String CountryName);

}
