/**
 * 
 */
package com.weather.forecast.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.weather.forecast.beans.DefaultProperties;

/**
 * @author anandsingh
 *
 */
@Configuration
public class GeneralConfiguration {
	
	@Bean
	public RestTemplate restTemplate()
	{
		return new RestTemplate();
	}
	
	@Bean
	public DefaultProperties defaultProperties()
	{
		return new DefaultProperties();
	}

}
