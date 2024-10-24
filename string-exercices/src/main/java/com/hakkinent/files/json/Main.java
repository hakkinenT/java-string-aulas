package com.hakkinent.files.json;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.hakkinent.files.json.entities.Course;
import com.hakkinent.files.json.entities.Lesson;

public class Main {
    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();
         objectMapper.registerModule(new JavaTimeModule());

        try {
            File jsonFile = new File("string-exercices\\src\\main\\resources\\file.json");
            List<Course> courses = objectMapper.readValue(jsonFile, new TypeReference<List<Course>>() {});

            for(Course course : courses){
                System.out.println("Curso id: " + course.getId());
                System.out.println("Curso name: " + course.getTitle());

                List<Lesson> lessons = course.getLessons();

                for(Lesson lesson : lessons){
                    System.out.println(lesson.getId());
                    System.out.println(lesson.getMedia());
                    System.out.println(lesson.getTitle());
                    System.out.println(lesson.getTimestamp());
                }
                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
