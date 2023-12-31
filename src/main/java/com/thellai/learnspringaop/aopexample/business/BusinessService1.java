package com.thellai.learnspringaop.aopexample.business;

import com.thellai.learnspringaop.aopexample.annotations.TrackTime;
import com.thellai.learnspringaop.aopexample.data.DataService1;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class BusinessService1 {

    private DataService1 dataService1;

    public BusinessService1( DataService1 dataService1 ){
        this.dataService1 = dataService1;
    }

    @TrackTime
    public int calculateMax()  {
        int[] data = dataService1.retrieveData();

        try{ // this is included, just to check the working of @Around aspect.
            Thread.sleep(300);
        }catch (InterruptedException ie ){
            ie.printStackTrace();
        }

        //throw new RuntimeException("machi open the bottle");

        return Arrays.stream( data ).max().orElse( 0 );
    }

}
