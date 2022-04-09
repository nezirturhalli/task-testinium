package com.testinium.sgms.config;

import com.testinium.sgms.dto.request.AddCourseRequest;
import com.testinium.sgms.dto.request.AddStudentRequest;
import com.testinium.sgms.dto.response.*;
import com.testinium.sgms.entity.*;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DtoModelMapperConfig {
    private static final Converter<AddStudentRequest, Student> ADD_STUDENT_REQUEST_STUDENT_CONVERTER =
            context -> Student.builder()
                    .studentId(context.getSource().getStudentId())
                    .firstName(context.getSource().getFirstName())
                    .lastName(context.getSource().getLastName())
                    .build();

    private static final Converter<Student, GenericStudentResponse> STUDENT_GENERIC_STUDENT_RESPONSE_CONVERTER =
            context -> GenericStudentResponse.builder()
                    .studentId(context.getSource().getStudentId())
                    .firstName(context.getSource().getFirstName())
                    .lastName(context.getSource().getLastName())
                    .build();


    private static final Converter<Grade, GradeResponse> GRADE_GRADE_RESPONSE_CONVERTER =
            context -> GradeResponse.builder()
                    .midterm(context.getSource().getMidterm())
                    .finalExam(context.getSource().getFinalExam())
                    .averageExam(context.getSource().getAverageExam())
                    .schoolYear(context.getSource().getYear())
                    .build();

    private static final Converter<AddCourseRequest, Course> ADD_COURSE_REQUEST_COURSE_CONVERTER =
            context -> Course.builder()
                    .code(context.getSource().getCourseCode())
                    .courseName(context.getSource().getCourseName())
                    .grade(Grade.builder().year(context.getSource().getYear()).build())
                    .build();

    private static final Converter<StudentCourses, StudentResponse> STUDENT_COURSES_STUDENT_ASSIGN_RESPONSE_CONVERTER =
            context -> StudentResponse.builder()
                    .studentId(context.getSource().getStudentId())
                    .courseResponse(CourseResponse.builder()
                            .courseCode(context.getSource().getCourseCode())
                            .response(GradeResponse.builder()
                                    .schoolYear(SchoolYear.ACTIVE)
                                    .build())
                            .build())
                    .build();


    private static final Converter<Course, CourseResponse> COURSE_COURSE_RESPONSE_CONVERTER =
            context -> CourseResponse.builder()
                    .courseCode(context.getSource().getCode())
                    .courseName(context.getSource().getCourseName())
                    .response(GradeResponse.builder().schoolYear(context.getSource().getGrade().getYear()).build())
                    .build();

    private static final Converter<Course, GenericCoursesResponse> COURSE_GENERIC_COURSES_RESPONSE_CONVERTER =
            context -> GenericCoursesResponse.builder()
                    .courseCode(context.getSource().getCode())
                    .courseName(context.getSource().getCourseName())
                    .year(context.getSource().getGrade().getYear())
                    .build();

    @Bean
    ModelMapper modelMapper() {
        var modelMapper = new ModelMapper();
        modelMapper.addConverter(GRADE_GRADE_RESPONSE_CONVERTER, Grade.class, GradeResponse.class);
        modelMapper.addConverter(STUDENT_COURSES_STUDENT_ASSIGN_RESPONSE_CONVERTER, StudentCourses.class, StudentResponse.class);
        modelMapper.addConverter(ADD_COURSE_REQUEST_COURSE_CONVERTER, AddCourseRequest.class, Course.class);
        modelMapper.addConverter(STUDENT_GENERIC_STUDENT_RESPONSE_CONVERTER, Student.class, GenericStudentResponse.class);
        modelMapper.addConverter(COURSE_GENERIC_COURSES_RESPONSE_CONVERTER, Course.class, GenericCoursesResponse.class);
        modelMapper.addConverter(ADD_STUDENT_REQUEST_STUDENT_CONVERTER, AddStudentRequest.class, Student.class);
        modelMapper.addConverter(COURSE_COURSE_RESPONSE_CONVERTER, Course.class, CourseResponse.class);
        return modelMapper;
    }
}