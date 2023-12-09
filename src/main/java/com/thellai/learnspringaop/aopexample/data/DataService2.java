package com.thellai.learnspringaop.aopexample.data;

import com.thellai.learnspringaop.aopexample.annotations.TrackTime;
import org.springframework.stereotype.Repository;

@Repository
public class DataService2 {

    @TrackTime
    public int[] retrieveData(){
        /*
            usually, this method will interreact with data base and return data, but in this example
            we are hardcoding the returned value.
        */

        try{ // this is included, just to check the working of @Around aspect.
            Thread.sleep(300);
        }catch (InterruptedException ie ){
            ie.printStackTrace();
        }

        return new int[]{111,222,333,444,555,666,777,888,8888,000};
    }
}
