package com.thellai.learnspringaop.aopexample.data;

import org.springframework.stereotype.Repository;

@Repository
public class DataService1 {

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
        return new int[]{1,2,3,4,5,6,7,8,88,0};
    }
}
