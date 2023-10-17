package com.learnJava.parallelstreams;

import java.util.stream.IntStream;

public class SumClient {

    public static void main(String[] args) {

        Sum sum=new Sum();
        
     /*   IntStream.rangeClosed(1,1000)
        .forEach(sum::performSum); //result is : 500500
*/        
        IntStream.rangeClosed(1,1000)
                .parallel()
                .forEach(sum::performSum); //result is not always 500500

        System.out.println(sum.getTotal());
        //If you have any mutable variable then don't use parallel stream.
        //Here parallel streams are concurrently accessing the total variable 
        //hence we don't get consistent result.
        
    }
}
