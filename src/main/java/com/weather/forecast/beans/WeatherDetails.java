/**
 * 
 */
package com.weather.forecast.beans;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author anandsingh
 *
 */
public class WeatherDetails {
	
	@JsonProperty("name")
	private String cityName;
	private String countryName;
	
	private String minTemp;
	private String maxTemp;
	private String summary;
	private String icon;
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
	
	@JsonProperty("sys")
	private void unpackSysFromNestedObject(Map<String, String> sys) {
	    countryName = sys.get("country");
	}
	public String getCountryName() {
		return countryName;
	}
	/**
	 * @param countryName the countryName to set
	 */
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	@JsonProperty("main")
	private void unpackMainFromNestedObject(Map<String, String> main) {
		icon = main.get("humidity");
	    minTemp = main.get("temp_min");
	    maxTemp = main.get("temp_max");
	    summary = main.get("temp");
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

}
