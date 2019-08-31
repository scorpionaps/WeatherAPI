/**
 * 
 */
package com.weather.forecast.services;

import java.time.LocalDate;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.weather.forecast.beans.WeatherDetails;
import com.weather.forecast.entity.WeatherForecastEntity;
import com.weather.forecast.repository.WeatherForecastRepository;

/**
 * @author anandsingh
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class WeatherForecastServiceImplTest {

	@Autowired
	WeatherForecastService weatherForecastService;
	@MockBean
	WeatherForecastRepository weatherForecastRepository;


	@Test
	public void getWeatherDetailsForCityIfEntryPresentInDBIsOfToday() {
		WeatherForecastEntity weatherForecastEntity = new WeatherForecastEntity("Singapore/SG","Singapore", "SG", "123.41", "128.78", "125.45", "56", "system", LocalDate.now());
		Mockito.when(weatherForecastRepository.findBycityNameAndCountryName("Singapore", "SG")).thenReturn(weatherForecastEntity);
		WeatherDetails weatherDetails = weatherForecastService.getWeatherDetailsForCity("Singapore", "SG");
		Assert.assertEquals(weatherDetails.getMaxTemp(), weatherForecastEntity.getMaxTemp());
		Assert.assertEquals(weatherDetails.getMinTemp(), weatherForecastEntity.getMinTemp());
	}

}
