package com.learnJava.methodreferences;

import com.learnJava.data.Student;

import java.util.function.Function;
import java.util.function.Supplier;

public class SupplierMethodReferenceExample {

	static Supplier<Student> studentSupplier = Student::new; //Student class should have no arg constructor
	//Becoz Supplier has get() method which does not take any arg but returns result.
	//Comment no-arg constructor and check
    //Student student = Student::new; // compilation issue
    static Function<String,Student> studentFunction = Student::new; //STudent class should have constructor
    //String as one argument which takes  as we are defining a function which take String as argument and
    //return type as Student
    
    public static void main(String[] args) {

        System.out.println(studentSupplier.get());
        System.out.println(studentFunction.apply("Yogesh"));


    }
}
