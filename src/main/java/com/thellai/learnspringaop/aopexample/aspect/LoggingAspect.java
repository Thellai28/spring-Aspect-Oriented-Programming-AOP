package com.thellai.learnspringaop.aopexample.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
@Aspect // this is an aspect class :
public class LoggingAspect {

    private  Logger logger = LoggerFactory.getLogger( getClass() );

    @Before("com.thellai.learnspringaop.aopexample.aspect.CommonPointcutConfig.businessAndDataPackageConfig()")
    public void logMethodCallBeforeExecution( JoinPoint joinPoint ){
        logger.info("Before aspect -{},  Method is called - {}", joinPoint, joinPoint.getArgs());
    }

    @After("com.thellai.learnspringaop.aopexample.aspect.CommonPointcutConfig.businessPackageConfig()")
    public void logMethodCallAfterExecution( JoinPoint joinPoint ){
        logger.info("After aspect -{},  has executed", joinPoint);
    }

    @AfterThrowing(
            pointcut = "com.thellai.learnspringaop.aopexample.aspect.CommonPointcutConfig.businessAndDataPackageConfig()"
            , throwing = "ex"
    )
    public void logMethodCallAfterException( JoinPoint joinPoint, Exception ex ){
        logger.info("AfterThrowing aspect -{},  has thrown an exception{}", joinPoint, ex);
    }

    @AfterReturning(
            pointcut = "com.thellai.learnspringaop.aopexample.aspect.CommonPointcutConfig.dataPackageConfig()"
            , returning = "resultValue"
    )
    public void logMethodCallAfterSuccessfulExecution( JoinPoint joinPoint, Object resultValue ){
        logger.info("AfterReturning aspect -{},  has returned {}", joinPoint, resultValue);
    }
}
