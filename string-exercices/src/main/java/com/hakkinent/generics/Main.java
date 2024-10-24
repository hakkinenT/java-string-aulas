package com.hakkinent.generics;

import java.util.ArrayList;
import java.util.List;

import com.hakkinent.generics.models.Person;
import com.hakkinent.generics.models.Student;
import com.hakkinent.generics.models.Teacher;

public class Main {
    public static void main(String[] args) {
        List<Person> people = List.of(new Person("p1", 10), new Person("p2", 15));
        Person max = Calculator.max(people);
        System.out.println(max.getName());
        System.out.println(max.getAge());

        List<Person> schoolPeople = List.of(new Student("Alex", 15), new Teacher("Paul", 45));
        List<Student> students = List.of(new Student("Alex", 15), new Student("Liam", 12));
        List<Teacher> teachers = List.of(new Teacher("Greg", 35), new Teacher("Paul", 45));
        System.out.println("List<? extends Person>");
        /*
         * List<? super Person>
         * Pode ser qualquer lista do tipo Person ou de qualquer um de seus
         * subtipos como Student ou Teacher
         */
        System.out.println("Person");
        printList(schoolPeople);
        System.out.println("Teacher");
        printList(teachers);
        System.out.println("Student");
        printList(students);

        System.out.println();
        System.out.println("List<? super Person>");
        /*
         * List<? super Person>
         * Pode ser qualquer lista do tipo Person ou de qualquer um de seus
         * super tipos como Object
         */
        System.out.println("Person");
        printList2(schoolPeople);
        List<Object> list = new ArrayList<>();
        System.out.println("Object");
        list.add("Maria");
        list.add("João");
        printList2(list);
        //! printList2(teachers); dá erro
        //! printList2(students); dá erro
    }

    public static void printList(List<? extends Person> list){
        
        for(Object obj : list){
            System.out.println(obj);
        }
    }

    public static void printList2(List<? super Person> list){
        
        for(Object obj : list){
            System.out.println(obj);
        }
    }
}
