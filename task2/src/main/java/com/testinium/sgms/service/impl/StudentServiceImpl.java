package com.testinium.sgms.service.impl;

import com.testinium.sgms.dto.request.AddStudentRequest;
import com.testinium.sgms.dto.request.StudentCoursesRequest;
import com.testinium.sgms.dto.request.StudentRequest;
import com.testinium.sgms.dto.response.CourseResponse;
import com.testinium.sgms.dto.response.GenericStudentResponse;
import com.testinium.sgms.dto.response.GradeResponse;
import com.testinium.sgms.dto.response.StudentResponse;
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
    public StudentResponse getStudentById(StudentRequest studentRequest) {
        var student = studentCoursesRepository.findByStudentId(studentRequest.getStudentId());
        var courseCode = courseRepository.findByCode(student.getCourseCode());
        return StudentResponse.builder()
                .studentId(student.getStudentId())
                .courseResponse(CourseResponse.builder()
                        .courseCode(courseCode.getCode())
                        .courseName(courseCode.getCourseName())
                        .response(GradeResponse.builder().midterm(50.5)
                                .finalExam(75.0)
                                .averageExam(80.0)
                                .schoolYear(courseCode.getGrade().getYear())
                                .build())
                        .build())
                .build();

    }

    @Override
    public List<StudentResponse> getAllStudentsGrades() {
        var student = studentRepository.findAll();
        return student.stream()
                .map(student1 -> {
                    var studentRequest = StudentRequest.builder()
                            .studentId(student1.getStudentId())
                            .build();
                    return getStudentById(studentRequest);
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
                .courseCode(course.getCode())
                .studentId(student.getStudentId())
                .build();
        return modelMapper.map(studentCoursesRepository.save(saveCourse), StudentResponse.class);


    }

}
