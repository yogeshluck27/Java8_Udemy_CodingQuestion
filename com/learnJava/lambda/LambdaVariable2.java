package com.learnJava.lambda;

import java.util.function.Consumer;

public class LambdaVariable2 {

    static int value =4; //This is an instance variable 
    //We can use same name in Lambda as well as we can modify its values.
    //No restrictions on Instance  variable

    public static void main(String[] args) {


         //int value =4; //effectively final
        Consumer<Integer> c1 = (a) -> {
            value = 6;
             System.out.println(a+value);  
        	
        	//If we have value as local variable then reassigning it to different value
        	// or changing its value is not allowed 
             //If its a instance variable then its allowed
        };
        value =2;
        //System.out.println("Value is "+value);  
        c1.accept(2);
    }
}
