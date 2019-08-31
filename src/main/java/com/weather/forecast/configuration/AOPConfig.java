/**
 * 
 */
package com.weather.forecast.configuration;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

/**
 * @author anandsingh
 *
 */
@Aspect
@Configuration
public class AOPConfig {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Before("execution(* com.weather.forecast.services.*.*(..))")
    public void before(JoinPoint joinPoint) {
        //Advice
        logger.info(" Allowed execution for {}", joinPoint);
    }
	
	@After(value = "execution(* com.weather.forecast.services.*.*(..))")
    public void after(JoinPoint joinPoint) {
        logger.info("after execution of {}", joinPoint);
    }

}
