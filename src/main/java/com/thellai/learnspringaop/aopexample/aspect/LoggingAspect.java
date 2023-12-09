package com.thellai.learnspringaop.aopexample.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
@Aspect // this is an aspect class :
public class LoggingAspect {

    private Logger logger = LoggerFactory.getLogger( getClass() );

    @Before("execution(* com.thellai.learnspringaop.aopexample.business.*.*(..))")
    public void logMethodCall( JoinPoint joinPoint ){
        logger.info("Before aspect - Method is called - {}", joinPoint);
    }
}
