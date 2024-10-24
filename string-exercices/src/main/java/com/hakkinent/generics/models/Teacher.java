package com.hakkinent.generics.models;

public class Teacher extends Person{
    public Teacher(){}

    public Teacher(String name, Integer age){
        super(name, age);
    }
    
    @Override
    public String toString() {
        return "Nome do professor: " + getName() + ", Idade: " + getAge();
    }
}
