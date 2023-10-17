package com.learnJava.constructorReference;

import com.learnJava.data.Student;

import java.util.function.Function;
import java.util.function.Supplier;

public class ConstructorReferenceExample {

    static Supplier<Student> studentSupplier = Student::new;

    //static Student studentSupplier1 = Student::new; //This is not valid

    static Function<String, Student> studentFunction = Student::new;

    //Student student = Student::new; this is not valid

    public static void main(String[] args) {

        System.out.println(studentSupplier.get());

        System.out.println(studentFunction.apply("Client123"));
    }
}
