package com.learnJava.streams;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectionsvsStreams {

    public static void main(String[] args) {

        ArrayList<String> names = new ArrayList<>();
        names.add("Adam");
        names.add("Jim");
        names.add("Jenny");

        Stream<String> namesStream = names.stream();
        //namesStream.add()     //Cannot add or remove elements
        
        namesStream.forEach(System.out::println);
        //namesStream.forEach(System.out::println);  //cannot iterate n no of times
        
        //namesStream.get(4)  //cannot access any element //Its sequential access only
        names.get(1);
        
        namesStream.collect(Collectors.toList()); // There has to be terminal operation.Streams are lazily constructed
        
        
        //Collections perform external iteration to iterate through element --using for loop
        //Streams Performs internal iterations to iterate through elements
        
    }
}
