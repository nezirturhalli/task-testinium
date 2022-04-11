package com.testinium.sgms.config;

import com.testinium.sgms.dto.request.AddCourseRequest;
import com.testinium.sgms.dto.request.AddGradeRequest;
import com.testinium.sgms.dto.request.AddStudentRequest;
import com.testinium.sgms.dto.response.*;
import com.testinium.sgms.entity.Course;
import com.testinium.sgms.entity.Grade;
import com.testinium.sgms.entity.Student;
import com.testinium.sgms.entity.StudentCourses;
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
                    .build();

    private static final Converter<AddCourseRequest, Course> ADD_COURSE_REQUEST_COURSE_CONVERTER =
            context -> Course.builder()
                    .code(context.getSource().getCourseCode())
                    .courseName(context.getSource().getCourseName())
                    .build();

    private static final Converter<StudentCourses, StudentResponse> STUDENT_COURSES_STUDENT_ASSIGN_RESPONSE_CONVERTER =
            context -> StudentResponse.builder()
                    .studentId(context.getSource().getStudentId())
                    .courseResponse(CourseResponse.builder()
                            .courseCode(context.getSource().getCourseCode())
                            .schoolYear(context.getSource().getYear())
                            .response(GradeResponse.builder()
                                    .midterm(context.getSource().getGrade().getMidterm())
                                    .finalExam(context.getSource().getGrade().getFinalExam())
                                    .averageExam(context.getSource().getGrade().getAverageExam())
                                    .build())
                            .build())
                    .build();


    private static final Converter<Course, CourseResponse> COURSE_COURSE_RESPONSE_CONVERTER =
            context -> CourseResponse.builder()
                    .courseCode(context.getSource().getCode())
                    .courseName(context.getSource().getCourseName())
                    .build();

    private static final Converter<Course, GenericCoursesResponse> COURSE_GENERIC_COURSES_RESPONSE_CONVERTER =
            context -> GenericCoursesResponse.builder()
                    .courseCode(context.getSource().getCode())
                    .courseName(context.getSource().getCourseName())
                    .build();

    private static final Converter<AddGradeRequest, Grade> ADD_GRADE_REQUEST_GRADE_CONVERTER =
            context -> Grade.builder()
                    .midterm(context.getSource().getMidterm())
                    .finalExam(context.getSource().getFinalExam())
                    .studentCourses(StudentCourses.builder()
                            .studentId(context.getSource().getStudentId())
                            .courseCode(context.getSource().getCourseCode())
                            .year(context.getSource().getYear())
                            .build())
                    .build();

    private static final Converter<Grade, AddGradeResponse> GRADE_ADD_GRADE_RESPONSE_CONVERTER =
            context -> AddGradeResponse.builder()
                    .studentCoursesResponse(StudentCoursesResponse.builder()
                            .studentId(context.getSource().getStudentCourses().getStudentId())
                            .courseCode(context.getSource().getStudentCourses().getCourseCode())
                            .schoolYear(context.getSource().getStudentCourses().getYear()).build())
                    .gradeResponse(GradeResponse.builder()
                            .midterm(context.getSource().getMidterm())
                            .finalExam(context.getSource().getFinalExam())
                            .averageExam(context.getSource().getAverageExam())
                            .status(context.getSource().getStatus())
                            .build())
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
        modelMapper.addConverter(ADD_GRADE_REQUEST_GRADE_CONVERTER, AddGradeRequest.class, Grade.class);
        modelMapper.addConverter(GRADE_ADD_GRADE_RESPONSE_CONVERTER, Grade.class, AddGradeResponse.class);
        return modelMapper;
    }
}