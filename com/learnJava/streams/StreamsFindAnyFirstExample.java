package com.learnJava.streams;

import com.learnJava.data.Student;
import com.learnJava.data.StudentDataBase;

import java.util.Optional;

public class StreamsFindAnyFirstExample {
//
	//The behavior of the findFirst method does not change in the parallel scenario. 
	//If the encounter order exists, it will always behave deterministically.
    public static Optional<Student> findAny(){

        return StudentDataBase.getAllStudents().stream()
                .filter(student -> student.getGpa()>=3.8)
                .findAny();
    }

    public static Optional<Student> findFirst(){

        return StudentDataBase.getAllStudents().stream()
                .filter(student -> student.getGpa()>=3.8)
                .findFirst();
    }

    public static void main(String[] args) {

        Optional<Student> findAnyStudent = findAny();
        if(findAnyStudent.isPresent()){
            System.out.println("Student is :" + findAnyStudent.get());
        }else{
            System.out.println("No Student Found");
        }

        Optional<Student> findFirst = findFirst();
        if(findFirst.isPresent()){
            System.out.println("Student is :" + findFirst.get());
        }else{
            System.out.println("No Student Found");
        }
        //it will make a lot of different during parallel stream
        //The behavior of findAny() operation is explicitly nondeterministic; 
        //it is free to select any element in the stream. 
        //This is to allow for maximal performance in parallel operations; 
        //the cost is that multiple invocations on the same source may not return the same result. 
        //(If a stable result is desired, use findFirst() instead
    }
}
