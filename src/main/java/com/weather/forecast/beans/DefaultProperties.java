/**
 * 
 */
package com.weather.forecast.beans;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author anandsingh
 *
 */
@ConfigurationProperties(prefix="default")
public class DefaultProperties {
	
	private String defaultLocations;
	
	private String myAppKey;
	
	private String mlabKey;

	/**
	 * @return the mlabKey
	 */
	public String getMlabKey() {
		return mlabKey;
	}

	/**
	 * @param mlabKey the mlabKey to set
	 */
	public void setMlabKey(String mlabKey) {
		this.mlabKey = mlabKey;
	}

	public String getMyAppKey() {
		return myAppKey;
	}

	public void setMyAppKey(String myAppKey) {
		this.myAppKey = myAppKey;
	}

	public String getDefaultLocations() {
		return defaultLocations;
	}

	public void setDefaultLocations(String defaultLocations) {
		this.defaultLocations = defaultLocations;
	}
	

}
