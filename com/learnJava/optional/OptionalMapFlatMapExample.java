package com.learnJava.optional;

import com.learnJava.data.Bike;
import com.learnJava.data.Student;
import com.learnJava.data.StudentDataBase;

import java.util.Optional;

public class OptionalMapFlatMapExample {

    public static void optionalFlatMap(){
      Optional<Student> studentOptional =  StudentDataBase.getOptionalStudent();//Optional<Student>
      if(studentOptional.isPresent()){
          Optional<String> bikeOptional= 
        		  studentOptional
        		  .filter(student->student.getGpa()>=3.5) //Optional<Student <Optional<Bike>>
                  .flatMap(Student::getBike) // Optional<Bike>
          		  .map(bike->bike.getName()); //Optional<String>
          bikeOptional.ifPresent(s -> System.out.println("Bike name is "+s));
          //System.out.println("bikeOptional : " + bikeOptional);
      }
    }

    public static void optionalMap(){
        Optional<Student> studentOptional =  StudentDataBase.getOptionalStudent();

        if(studentOptional.isPresent()){
            Optional<String> nameOptional= 
            		studentOptional //Optional<Student>
                    .map(Student::getName); //Optional<String>
            nameOptional.ifPresent(s->System.out.println("nameOptional : " + nameOptional));
            
        }
    }

    public static void optionalFilter(){

        Optional<Student> studentOptional = 
        		StudentDataBase.getOptionalStudent() //Optional<Student>
                .filter(student -> student.getGpa()>=3.5); //Optional<Student>

        studentOptional.ifPresent(student -> System.out.println(student));

    }

    public static void main(String[] args) {
        optionalFlatMap();
        optionalMap();
        optionalFilter();
    }
}
