/**
 * 
 */
package com.weather.forecast.housekeeping;

import java.time.LocalDate;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.weather.forecast.entity.WeatherForeCastEntity;
import com.weather.forecast.repository.WeatherForecastRepository;

/**
 * @author anandsingh
 *
 */
@Component
public class ScheduledFixedRateHouseKeeper {
	
	@Autowired
	WeatherForecastRepository weatherForecastRepository;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Scheduled(fixedRate = 120000)
    public void scheduleFixedRateTaskAsync() throws InterruptedException {
		logger.info(
          "House Keeping Task Executed now at - " + System.currentTimeMillis() / 1000);
		
		List<WeatherForeCastEntity> listOfWeatherForeCastEntity = weatherForecastRepository.findAll();
		for(WeatherForeCastEntity weatherForeCastEntity: listOfWeatherForeCastEntity)
		{
			if(weatherForeCastEntity.getLastUpdDate().isBefore(LocalDate.now().minusDays(3)))
			{
				weatherForecastRepository.delete(weatherForeCastEntity);
			}
		}
		
    }

}
