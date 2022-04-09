package com.testinium.sgms.config;

import com.testinium.sgms.entity.*;
import com.testinium.sgms.repository.CourseRepository;
import com.testinium.sgms.repository.GradeRepository;
import com.testinium.sgms.repository.StudentCoursesRepository;
import com.testinium.sgms.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class StudentConfig implements CommandLineRunner {
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;
    private final GradeRepository gradeRepository;
    private final StudentCoursesRepository studentCoursesRepository;

    @Override
    public void run(String... args) {

        Grade gradeAA = gradeRepository.save(new Grade(1L, 65.5, 75.0, ((65.5 + 75.0) / 2), SchoolYear.ACTIVE));
        Grade gradeAP = gradeRepository.save(new Grade(2L, 25.5, 15.0, ((25.5 + 15.0) / 2), SchoolYear.PASSIVE));
        Grade gradeBA = gradeRepository.save(new Grade(3L, 75.5, 95.0, ((75.5 + 95.0) / 2), SchoolYear.ACTIVE));
        Grade gradeBP = gradeRepository.save(new Grade(4L, 35.5, 5.0, ((35.5 + 5.0) / 2), SchoolYear.PASSIVE));
        Grade gradeCP = gradeRepository.save(new Grade(5L, 95.0, 100.0, ((95.0 + 100.0) / 2), SchoolYear.PASSIVE));


        var course1 = courseRepository.save(new Course(1L, "MATH", "Mathematics", gradeAA));
        var course2 = courseRepository.save(new Course(2L, "MATH", "Mathematics", gradeAP));
        var course3 = courseRepository.save(new Course(3L, "PHY", "Physics", gradeBA));
        var course4 = courseRepository.save(new Course(4L, "PHY", "Physics", gradeBP));
        var course5 = courseRepository.save(new Course(5L, "CHE", "Chemistry", gradeCP));

        Student student1 = studentRepository.save(new Student(1L, "1111213", "Ali", "Test"));
        Student student2 = studentRepository.save(new Student(2L, "1112211", "Veli", "Test"));
        Student student3 = studentRepository.save(new Student(3L, "1511211", "Mehmet", "Test"));

        StudentCourses studentCourse1 = studentCoursesRepository.save(new StudentCourses(1L, student1.getStudentId(), course1.getCode()));
        StudentCourses studentCourse2 = studentCoursesRepository.save(new StudentCourses(2L, student1.getStudentId(), course2.getCode()));
        StudentCourses studentCourse3 = studentCoursesRepository.save(new StudentCourses(3L, student2.getStudentId(), course3.getCode()));
        StudentCourses studentCourse4 = studentCoursesRepository.save(new StudentCourses(4L, student3.getStudentId(), course4.getCode()));
        StudentCourses studentCourse5 = studentCoursesRepository.save(new StudentCourses(5L, student2.getStudentId(), course5.getCode()));

        System.out.println(student1);
        System.out.println(student2);
        System.out.println(student3);
        System.out.println(course1);
        System.out.println(course2);
        System.out.println(course3);
        System.out.println(course4);
        System.out.println(course5);
        System.out.println(studentCourse1);
        System.out.println(studentCourse2);
        System.out.println(studentCourse3);
        System.out.println(studentCourse4);
        System.out.println(studentCourse5);


    }
}
