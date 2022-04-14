package com.testinium.sgms.service.impl;

import com.testinium.sgms.dto.request.AddStudentRequest;
import com.testinium.sgms.dto.request.GenericGradeRequest;
import com.testinium.sgms.dto.request.StudentCoursesRequest;
import com.testinium.sgms.dto.response.CourseResponse;
import com.testinium.sgms.dto.response.GenericStudentResponse;
import com.testinium.sgms.dto.response.GradeResponse;
import com.testinium.sgms.dto.response.StudentResponse;
import com.testinium.sgms.entity.Grade;
import com.testinium.sgms.entity.Student;
import com.testinium.sgms.entity.StudentCourses;
import com.testinium.sgms.repository.CourseRepository;
import com.testinium.sgms.repository.StudentCoursesRepository;
import com.testinium.sgms.repository.StudentRepository;
import com.testinium.sgms.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;
    private final StudentCoursesRepository studentCoursesRepository;
    private final ModelMapper modelMapper;


    @Override
    public StudentResponse getStudentById(GenericGradeRequest request) {
        var student = studentCoursesRepository.findByStudentIdAndCourseCodeAndYear(request.getStudentId(),
                request.getCourseCode(), request.getYear());
        return StudentResponse.builder()
                .studentId(student.getStudentId())
                .courseResponse(CourseResponse.builder()
                        .courseCode(student.getCourseCode())
                        .schoolYear(student.getYear())
                        .response(GradeResponse.builder()
                                .midterm(student.getGrade().getMidterm())
                                .finalExam(student.getGrade().getFinalExam())
                                .averageExam(student.getGrade().getAverageExam())
                                .status(student.getGrade().getStatus())
                                .build())
                        .build())
                .build();


    }

    @Override
    public List<StudentResponse> getAllStudentsGrades() {
        var student = studentCoursesRepository.findAll();
        return student.stream()
                .map(s -> {
                    var request = GenericGradeRequest.builder()
                            .studentId(s.getStudentId())
                            .courseCode(s.getCourseCode())
                            .year(s.getYear())
                            .build();
                    return getStudentById(request);
                }).toList();
    }

    @Override
    public List<GenericStudentResponse> getAllStudents() {
        return studentRepository.findAll().stream()
                .map(student -> modelMapper.map(student, GenericStudentResponse.class))
                .toList();
    }

    @Override
    public GenericStudentResponse addNewStudent(AddStudentRequest studentRequest) {
        var student = modelMapper.map(studentRequest, Student.class);
        return modelMapper.map(studentRepository.save(student), GenericStudentResponse.class);
    }

    @Override
    public StudentResponse assign(StudentCoursesRequest studentCourses) {
        var student = studentRepository.findByStudentId(studentCourses.getStudentId());
        var course = courseRepository.findByCode(studentCourses.getCourseCode());
        var saveCourse = StudentCourses.builder()
                .studentId(student.getStudentId())
                .courseCode(course.getCode())
                .year(studentCourses.getSchoolYear())
                .grade(Grade.builder()
                        .midterm(0.0)
                        .finalExam(0.0)
                        .averageExam(0.0)
                        .build())
                .build();
        return modelMapper.map(studentCoursesRepository.saveAndFlush(saveCourse), StudentResponse.class);


    }

}
