package com.thellai.learnspringaop.aopexample.aspect;

import com.thellai.learnspringaop.aopexample.annotations.TrackTime;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
@Aspect
public class PerformanceTrackingAspect {
    private Logger logger = LoggerFactory.getLogger( getClass() );

    //@Around("com.thellai.learnspringaop.aopexample.aspect.CommonPointcutConfig.businessAndDataPackageConfig()")
    @Around("com.thellai.learnspringaop.aopexample.aspect.CommonPointcutConfig.trackTimeAnnotation()") // just intercepts
    // the methods with @TrackTime annotation.
    public Object findExecutionTime( ProceedingJoinPoint proceedingJoinPoint ) throws Throwable {
        /*
            @Around is different form other annotations, all the other annotations will be executed either before
            executing or after executing or when throwing exceptions or returning something but this around annotation
            will do soemthing before executing a method and after executing a method.

            meaning, few set of instructions will be executed before the actual method executions, so we have to start
            the executions once the prerequisit instructions are executed. Once the method execution is done, the control
            will function execution flow will not be reverted back to the caller function, the functions flow remains
            in the same aspect class or aspect method until the post method execution are executed.

            We need control over when the execution will start and the execution will end, this kind of control is not
            provided by the normal "JoinPoint", so we use "proceedingJoinPoint"
        */

        //<---------------------------------BEFORE METHOD EXECUTION ---------------------------------------------->
        // Starting a timer :
        long startingTimeMillis = System.currentTimeMillis(); // instructions before method execution


        //<-------------------------------------- EXECUTING A METHOD --------------------------------------------->

        Object returnValue = proceedingJoinPoint.proceed();


        //<-------------------------------------AFTER METHOD EXECUTION --------------------------------------------->

        // Stopping a timer :
        long endingTimeMillis = System.currentTimeMillis();

        long totalExecutionTime = endingTimeMillis - startingTimeMillis;

        logger.info("Around aspect - {}, method executed in {} mill seconds", proceedingJoinPoint, totalExecutionTime);

        return returnValue;
    }
}
