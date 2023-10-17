package com.learnJava.streams;

import com.learnJava.data.Student;
import com.learnJava.data.StudentDataBase;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.maxBy;
import static java.util.stream.Collectors.toList;

public class StreamReduceExample {

    public static int performMultiplication(List<Integer> integerList){

        return integerList.stream()
        		//1 3 5 7
        		//a=1 (initial value) b=1 (from Stream)=> result 1 is returned
        		//a=1 (result from previous iteration) b=3(from Stream)-> result 3 is returned.
        		//a=3 b=5(from stream) -> result =15 
        		//a=15 b=7(from stream) ->result is 105
                .reduce(1, (a,b) -> a*b);

    }

    public static Optional<Integer> performMultiplicationWithNoInitialValue(List<Integer> integerList){

        return integerList.stream()
                .reduce( (a,b) -> a*b); // performs multiplication for each element in the stream 
        //and returns a new result.
        //Here we have not specified initial value in reduce . So result will be Optional
    }

    public static String combineStudentNames(){

        return StudentDataBase.getAllStudents().stream()
                .map(Student::getName)
                .distinct()
                .reduce(" ",(a,b) -> a.concat(b)); 
    }

    public static Optional<Student> getHighestGradeStudent(){
    	//This will return the student with highest GPA
        Optional<Student> studentOptional =  StudentDataBase.getAllStudents().stream()
                .reduce((s1,s2)->(s1.getGpa()>s2.getGpa()) ? s1 : s2);
        return studentOptional;
    }




    public static void main(String[] args) {

        //List<Integer> integerList = Arrays.asList(1,3,5,7);
        //List<Integer> integerList = Arrays.asList();

       /* System.out.println("Result is : " + performMultiplication(integerList));
        Optional<Integer> result = performMultiplicationWithNoInitialValue(integerList);

        if(result.isPresent()){
            System.out.println("Result is : " +result.get());
        }else{
            System.out.println("Result is : " +0);
        }*/

        System.out.println(combineStudentNames());
        //System.out.println(getHighestGradeStudent().get());
    }
}
