package com.learnJava.streams;

import com.learnJava.data.StudentDataBase;

public class StreamsMatchExample {


    public static boolean allMatch(){

        boolean result = StudentDataBase.getAllStudents().stream()
                .allMatch(student -> student.getGpa()>=3.9); //whether all students have GPA greater than 3.9

        return result;
    }

    public static boolean anyMatch(){

        boolean result = StudentDataBase.getAllStudents().stream()
                .anyMatch(student -> student.getGpa()>=4.0); //whether any of students in list has GPA greater than 3.9


        return result;
    }

    public static boolean noneMatch(){

        boolean result = StudentDataBase.getAllStudents().stream()
                .noneMatch(student -> student.getGpa()>=3.9); //whether no student has GPA greater than 3.9
        //opposite of all Match

        return result;
    }

    public static void main(String[] args) {

        System.out.println("Result of allMatch : " + allMatch());
        System.out.println("Result of anyMatch : " + anyMatch());
        System.out.println("Result of noneMatch : " + noneMatch());
    }
}
