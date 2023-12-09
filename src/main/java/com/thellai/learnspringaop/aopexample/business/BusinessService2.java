package com.thellai.learnspringaop.aopexample.business;

import com.thellai.learnspringaop.aopexample.data.DataService1;
import com.thellai.learnspringaop.aopexample.data.DataService2;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class BusinessService2 {

    private DataService2 dataService2;

    public BusinessService2( DataService2 dataService2 ){
        this.dataService2 = dataService2;
    }

    public int calculateMax()  {
        int[] data = dataService2.retrieveData();

        try{ // this is included, just to check the working of @Around aspect.
            Thread.sleep(300);
        }catch (InterruptedException ie ){
            ie.printStackTrace();
        }

        //throw new RuntimeException("machi open the bottle");

        return Arrays.stream( data ).max().orElse( 0 );
    }

}
