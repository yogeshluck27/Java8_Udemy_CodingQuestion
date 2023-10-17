package com.learnJava.defaults;

public class Client123 implements Interface1,Interface2,Interface3 {

    public void methodA(){ //overriding the default method in the implementation class.
        System.out.println("Inside method A "+ Client123.class);
    }
    //1  => class that implements interface
    //2 -> the sub interface that extends the interface
    
    public static void main(String[] args) {

        Client123 client123 = new Client123();
        client123.methodA(); // resolves to child Interface Implementation
        client123.methodB(); //If we add methodB to interface3 then it will be exeuted as its child interface
        client123.methodC();


    }
}
