package com.learnJava.optional;

import java.util.Optional;

public class OptionalPresentExample {

    public static void main(String[] args) {
        Optional<String> stringOptional1 = Optional.ofNullable(null);
        System.out.println(stringOptional1.isPresent());
        stringOptional1.ifPresent((s -> System.out.println("value is : " + s)));

        
        Optional<String> stringOptional = Optional.ofNullable("Hello Optional");
        System.out.println(stringOptional.isPresent());
        stringOptional.ifPresent((s -> System.out.println("value is : " + s)));
    }
}
