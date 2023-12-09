package com.thellai.learnspringaop.aopexample.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD) // Specifying this annotation can be used only on methods :
@Retention(RetentionPolicy.RUNTIME) // I want this to be executed at run time :
public @interface TrackTime {
}
