package com.testinium.sgms.config;

import com.testinium.sgms.entity.Course;
import com.testinium.sgms.entity.Student;
import com.testinium.sgms.repository.CourseRepository;
import com.testinium.sgms.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class StudentConfig implements CommandLineRunner {
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    @Override
    public void run(String... args) {

        var course1 = courseRepository.save(new Course(1L, "MATH", "Mathematics"));
        var course2 = courseRepository.save(new Course(2L, "PYH", "Physics"));
        var course3 = courseRepository.save(new Course(3L, "CHE", "Chemistry"));

        Student student1 = studentRepository.save(new Student(1L, "1111213", "Ali", "Test"));
        Student student2 = studentRepository.save(new Student(2L, "1112211", "Veli", "Test"));
        Student student3 = studentRepository.save(new Student(3L, "1511211", "Mehmet", "Test"));

        System.out.println(student1);
        System.out.println(student2);
        System.out.println(student3);

        System.out.println(course1);
        System.out.println(course2);
        System.out.println(course3);


    }
}
