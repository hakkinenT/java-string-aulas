package com.hakkinent.generics.models;

public class Student extends Person{
    public Student(){}

    public Student(String name, Integer age){
        super(name, age);
    }

    @Override
    public String toString() {
        return "Nome do estudante: " + getName() + ", Idade: " + getAge();
    }
}
