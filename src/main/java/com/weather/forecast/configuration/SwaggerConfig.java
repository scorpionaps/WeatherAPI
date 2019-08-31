/**
 * 
 */
package com.weather.forecast.configuration;

import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author anandsingh
 *
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	public Docket api()
	{
		return new  Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.weather.forecast.controller"))
				.paths(PathSelectors.ant("8*Default*"))
				.build();
	}

}
