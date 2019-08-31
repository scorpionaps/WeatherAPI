/**
 * 
 */
package com.weather.forecast.entity;


import java.time.LocalDate;

import org.springframework.data.annotation.Id;



/**
 * @author anandsingh
 *
 */

public class WeatherForeCastEntity {
	
	@Id
	private String weatherForecastId;
	
	private String cityName;
	

	private String countryName;
	
	private String minTemp;
	
	private String maxTemp;
	
	private String summary;
	
	private String icon;
	
	private String lastUpdId;
	
	private LocalDate lastUpdDate;
	
	
	/**
	 * @return the weatherForecastId
	 */
	public String getWeatherForecastId() {
		return weatherForecastId;
	}

	/**
	 * @param weatherForecastId the weatherForecastId to set
	 */
	public void setWeatherForecastId(String weatherForecastId) {
		this.weatherForecastId = weatherForecastId;
	}

	/**
	 * @return the cityName
	 */
	public String getCityName() {
		return cityName;
	}

	/**
	 * @param cityName the cityName to set
	 */
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	/**
	 * @return the countryName
	 */
	public String getCountryName() {
		return countryName;
	}

	/**
	 * @param countryName the countryName to set
	 */
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	/**
	 * @return the minTemp
	 */
	public String getMinTemp() {
		return minTemp;
	}

	/**
	 * @param minTemp the minTemp to set
	 */
	public void setMinTemp(String minTemp) {
		this.minTemp = minTemp;
	}

	/**
	 * @return the maxTemp
	 */
	public String getMaxTemp() {
		return maxTemp;
	}

	/**
	 * @param maxTemp the maxTemp to set
	 */
	public void setMaxTemp(String maxTemp) {
		this.maxTemp = maxTemp;
	}

	/**
	 * @return the summary
	 */
	public String getSummary() {
		return summary;
	}

	/**
	 * @param summary the summary to set
	 */
	public void setSummary(String summary) {
		this.summary = summary;
	}

	/**
	 * @return the icon
	 */
	public String getIcon() {
		return icon;
	}

	/**
	 * @param icon the icon to set
	 */
	public void setIcon(String icon) {
		this.icon = icon;
	}


	/**
	 * @return the lastUpdId
	 */
	public String getLastUpdId() {
		return lastUpdId;
	}

	/**
	 * @param lastUpdId the lastUpdId to set
	 */
	public void setLastUpdId(String lastUpdId) {
		this.lastUpdId = lastUpdId;
	}

	/**
	 * @return the lastUpdDate
	 */
	public LocalDate getLastUpdDate() {
		return lastUpdDate;
	}

	/**
	 * @param lastUpdDate the lastUpdDate to set
	 */
	public void setLastUpdDate(LocalDate lastUpdDate) {
		this.lastUpdDate = lastUpdDate;
	}
	
	

}
