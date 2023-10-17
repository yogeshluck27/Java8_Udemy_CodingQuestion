package com.learnJava.streams;

import com.learnJava.data.Student;
import com.learnJava.data.StudentDataBase;

import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class StreamsFilterExample {

    public static List<Student> filterStudents(){

        List<Student> filteredStudentList = StudentDataBase.getAllStudents()
                .stream() //Stream<Student>
                .filter(student -> student.getGpa()>=3.9) //Stream<Student> with filter condition
                .filter(student -> student.getGender().equals("female")) //Stream<Student> with filter condition
                .collect(toList()); //List of Student

        return filteredStudentList;
    }

    public static void main(String[] args) {

        System.out.println("Filtered Students : " + filterStudents());

    }
}
