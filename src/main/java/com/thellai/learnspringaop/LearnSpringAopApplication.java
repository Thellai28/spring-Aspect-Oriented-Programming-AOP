package com.thellai.learnspringaop;

import com.thellai.learnspringaop.aopexample.business.BusinessService1;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class LearnSpringAopApplication implements CommandLineRunner {
	Logger logger = LoggerFactory.getLogger(getClass());
	/*
		The logger is from import org.slf4j.LoggerFactory & import org.slf4j.Logger;
		Be aware, lots of logger classes and interfaces are present in java, if you
		imported wrong logger, you will see errors.
	 */

	private BusinessService1 businessService1;

	public LearnSpringAopApplication( BusinessService1 businessService1 ){
		this.businessService1 = businessService1;
	}


	public static void main(String[] args) {
		SpringApplication.run(LearnSpringAopApplication.class, args);
	}

	@Override
	public void run( String... args ) throws Exception {
		logger.info( "The returned value is {}.", businessService1.calculateMax() );
		businessService1.calculateMax();
	}
}
