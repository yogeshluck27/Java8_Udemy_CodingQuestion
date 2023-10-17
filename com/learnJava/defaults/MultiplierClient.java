package com.learnJava.defaults;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MultiplierClient {

    public static void main(String[] args) {

        Multiplier multiplier = new MultiplierImpl();
        List<Integer> inputList = Arrays.asList(1,3,5);
        System.out.println("Result is : " + multiplier.multiply(inputList));
        System.out.println("Input List size is : " + multiplier.size(inputList));
        System.out.println("Is Empty : " + Multiplier.isEmpty(inputList));

        //we have default method named size() in Multiplier Interface & overridden method in 
        //MultiplierImpl class. But at run time Overridden method class in IMPL will get invoked.
        
        //We have isEmpty static method in interface and impl class
        //But at runtime interface method will get called as we cannot override static.
        
        //Difference between Default And Static method is we cannot override the Static method 
        //But can override default method.
        
        
    }
}
