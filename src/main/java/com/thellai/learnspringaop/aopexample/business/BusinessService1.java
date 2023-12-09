package com.thellai.learnspringaop.aopexample.business;

import com.thellai.learnspringaop.aopexample.data.DataService1;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class BusinessService1 {

    private DataService1 dataService1;

    public BusinessService1( DataService1 dataService1 ){
        this.dataService1 = dataService1;
    }

    public int calculateMax(){
        int[] data = dataService1.retirieveData();

        return Arrays.stream( data ).max().orElse( 0 );
    }

}
