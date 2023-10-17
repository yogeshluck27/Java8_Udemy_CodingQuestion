package com.learnJava.streams;

import com.learnJava.data.Student;
import com.learnJava.data.StudentDataBase;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class StreamFlatMapExample {

    public static List<String> printStudentActivities() {

        List<String> studentActivities = StudentDataBase.getAllStudents()
                .stream()
                .map(Student::getActivities) //Stream<List<String>>
                .flatMap(List::stream) //<Stream<String>
                .collect(toList());//List<String>

        return studentActivities;

    }

    public static List<String> printUniqueStudentActivities() {

        List<String> studentActivities = StudentDataBase.getAllStudents()
                .stream()
                .map(Student::getActivities)//Stream<List<String>>
                .flatMap(List::stream)//Stream<String>>
                .distinct()//Stream<String>> unique elements
                .sorted()//Stream<String>> with alphabetical order
                .collect(toList());// List<String>

        return studentActivities;

    }

    public static long getStudentActivitiesCount() {

        long totalActivities = StudentDataBase.getAllStudents()
                .stream()//Stream<Student>
                .map(Student::getActivities)//Stream<List<String>>
                .flatMap(List::stream)//Stream<String>
                .distinct()//Stream<String> unique elements
                .count();//Count of elements

        return totalActivities;

    }

    public static void main(String[] args) {


        System.out.println("Student Activities : " + printStudentActivities());
        System.out.println("Unique Student Activities : " + printUniqueStudentActivities());
        System.out.println("Unique Student Activities Count: " + getStudentActivitiesCount());

    }

}
