package com.testinium.sgms.controller;

import com.testinium.sgms.dto.request.AddStudentRequest;
import com.testinium.sgms.dto.request.StudentCoursesRequest;
import com.testinium.sgms.dto.request.StudentRequest;
import com.testinium.sgms.dto.response.GenericStudentResponse;
import com.testinium.sgms.dto.response.StudentResponse;
import com.testinium.sgms.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;

import java.util.List;

@RestController
@RequestScope
@CrossOrigin
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentRestController {

    private final StudentService studentService;

    @PostMapping("/assign")
    public StudentResponse assignCourse(@RequestBody StudentCoursesRequest studentCourses) {
        return studentService.assign(studentCourses);
    }

    @PostMapping("/new")
    public GenericStudentResponse addNewStudent(@RequestBody AddStudentRequest studentRequest) {
        return studentService.addNewStudent(studentRequest);
    }

    @PostMapping("/getOneStudentGrades")
    public StudentResponse getOneStudentGrades(@RequestBody StudentRequest student) {
        return studentService.getStudentById(student);
    }

    @GetMapping("/getAllStudentsGrades")
    public List<StudentResponse> getAllStudentsGrades() {
        return studentService.getAllStudentsGrades();
    }

    @GetMapping
    public List<GenericStudentResponse> getAllStudentsList() {
        return studentService.getAllStudents();
    }

}
