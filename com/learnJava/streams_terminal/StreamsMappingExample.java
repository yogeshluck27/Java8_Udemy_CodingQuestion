package com.learnJava.streams_terminal;

import com.learnJava.data.Student;
import com.learnJava.data.StudentDataBase;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class StreamsMappingExample {

    public static void main(String[] args) {

       Set<String> namesSet = StudentDataBase.getAllStudents()
                .stream()
                .collect(mapping(Student::getName,toSet())); // this avoids the additional map intermediate operation.

        System.out.println("namesSet : " + namesSet);

        List<String> namesList = StudentDataBase.getAllStudents()
                .stream()
                .collect(mapping(Student::getName,toList())); // this avoids the additional map intermediate operation.

        List<String> namesListUsingMap = StudentDataBase.getAllStudents()
                .stream()//Stream<Student>
                .map(s->s.getName()) //Stream<String>
                .collect(Collectors.toList()); //List<String> Earlier we used to add intermediate map opration

        
        System.out.println("namesList : " + namesList);
        
        System.out.println("namesListUsingMap : " + namesListUsingMap);


    }

}
