/**
 * 
 */
package com.weather.forecast.services;

import java.net.URI;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriTemplate;

import com.weather.forecast.beans.DefaultProperties;
import com.weather.forecast.beans.WeatherDetails;
import com.weather.forecast.constants.WeatherForeCastConstants;
import com.weather.forecast.entity.WeatherForeCastEntity;
import com.weather.forecast.repository.WeatherForecastRepository;

/**
 * @author anandsingh
 *
 */
@Service
public class WeatherForecastServiceImpl implements WeatherForecastService {

	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private DefaultProperties defaultProperties;
	
	@Autowired
	private WeatherForecastRepository weatherForecastRepository;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Override
	@Cacheable("getDefaultWeatherForecast")
	public List<WeatherDetails> getDefaultWeatherForecast(String defaultLocations) {
		
		String[] locationsArray = defaultLocations.split(",");
		List<WeatherDetails> resultList = new ArrayList<WeatherDetails>();
		for(String locationDetails : locationsArray)
		{
			String cityName = locationDetails.split("/")[0];
			String countryName = locationDetails.split("/")[1];
			WeatherDetails weatherDetails = getWeatherDetailsForCity(cityName, countryName);
			resultList.add(weatherDetails);
			
		}
		
		return resultList;
	}
	
	@Override
	@Cacheable("getWeatherDetailsForCity")
	public WeatherDetails getWeatherDetailsForCity(String cityName, String countryName) {
		
		WeatherDetails weatherDetails = new WeatherDetails();
		logger.info("Call to fecth value from DB for City -{} and Country - {} started",cityName,countryName);
		WeatherForeCastEntity weatherForeCastEntity = weatherForecastRepository.findBycityNameAndCountryName(cityName, countryName);
		LocalDate todayDate = LocalDate.now();
		
		URI url = new UriTemplate(WeatherForeCastConstants.WEATHER_FORECAST_URL).expand(cityName, countryName, defaultProperties.getMyAppKey());
		if(weatherForeCastEntity!=null)
		{
			if(weatherForeCastEntity.getLastUpdDate().compareTo(todayDate) != 0)
			{
				weatherDetails = executeRestCall(url,WeatherDetails.class);
				
				if(weatherDetails!=null)
				{
				weatherForeCastEntity.setIcon(weatherDetails.getIcon());
				weatherForeCastEntity.setLastUpdDate(todayDate);
				weatherForeCastEntity.setLastUpdId("SYSTEM");
				weatherForeCastEntity.setMaxTemp(weatherDetails.getMaxTemp());
				weatherForeCastEntity.setMinTemp(weatherDetails.getMinTemp());
				weatherForeCastEntity.setSummary(weatherDetails.getSummary());
				weatherForecastRepository.save(weatherForeCastEntity);
				}
				else
				{
					weatherDetails = new WeatherDetails();
					weatherDetails.setCityName(cityName);
					weatherDetails.setCountryName(countryName);
				}

			}
			else
			{
				BeanUtils.copyProperties(weatherForeCastEntity, weatherDetails);
			}
		}
		else
		{
			weatherDetails = executeRestCall(url,WeatherDetails.class);
			if(weatherDetails!=null)
			{
			weatherForeCastEntity = new WeatherForeCastEntity();
			weatherForeCastEntity.setWeatherForecastId(cityName+countryName);
			weatherForeCastEntity.setCityName(cityName);
			weatherForeCastEntity.setCountryName(countryName);
			weatherForeCastEntity.setIcon(weatherDetails.getIcon());
			weatherForeCastEntity.setLastUpdDate(todayDate);
			weatherForeCastEntity.setLastUpdId("SYSTEM");
			weatherForeCastEntity.setMaxTemp(weatherDetails.getMaxTemp());
			weatherForeCastEntity.setMinTemp(weatherDetails.getMinTemp());
			weatherForeCastEntity.setSummary(weatherDetails.getSummary());
			weatherForecastRepository.save(weatherForeCastEntity);
			}
			else
			{
				weatherDetails = new WeatherDetails();
				weatherDetails.setCityName(cityName);
				weatherDetails.setCountryName(countryName);
			}
		}
		
		return weatherDetails;
	}

	private <T> T executeRestCall(URI url, Class<T> responseType) {
		RequestEntity<?> request = RequestEntity.get(url)
				.accept(MediaType.ALL).build();
		 logger.info(" Rest call to URL {}", url);
		
	try {
	ResponseEntity<T> response = this.restTemplate
		.exchange(request, responseType);

		return response.getBody();
	}
	catch(HttpStatusCodeException e)
	{
		return null;
	}
	}
}
