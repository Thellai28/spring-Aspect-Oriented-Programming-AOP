package com.thellai.learnspringaop.aopexample.aspect;

import org.aspectj.lang.annotation.Pointcut;

public class CommonPointcutConfig {
    /*
        WHY THIS CLASS EXIST? WHAT IS THE USE OF IT ?

        let's assume, your package name will change frequently, and you are using the point cut address in more than
        50 methods, a single change in package name will change result in changing all the methods with that specific
        package name

        To avoid this over head work, we specify all the ponitcut points in one common places, so that even the package name
        change will not affect, we just have to change the package name in one single place.

    */
    @Pointcut("execution(* com.thellai.learnspringaop.aopexample.*.*.*(..))")
    public void businessAndDataPackageConfig(){}



    @Pointcut("execution(* com.thellai.learnspringaop.aopexample.business.*.*(..))")
    public void businessPackageConfig(){}




    @Pointcut("execution(* com.thellai.learnspringaop.aopexample.data.*.*(..))")
    public void dataPackageConfig(){}



    @Pointcut("bean(*Service*)")
    public void allPackageConfigUsingBean(){
        /*
            if you need to point cut all the service classes in your application, you can target them using beans,
            the point cut mentioned in this method will target all the beans or classes with annotation @Services,
            if you want to target specific @Service bean, you can mention the package name before the @Service annotation

            for example : @Pointcut("bean(*dataService*)")
        */
    }


    @Pointcut ("@annotation(com.thellai.learnspringaop.aopexample.annotations.TrackTime)")
    public void trackTimeAnnotation(){
        /*
            To select and track specific methods, we can use this custom annotation, method. All the methods
            that have this custom annotation specified over them will be  intercepted, This would prevent us from
            intercepting all the method call that is directed to any specific package, we can precisely select method
            and intercept them when called.
        */
    }
}
