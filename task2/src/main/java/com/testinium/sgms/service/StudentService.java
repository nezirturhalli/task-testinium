package com.testinium.sgms.service;

import com.testinium.sgms.dto.request.AddStudentRequest;
import com.testinium.sgms.dto.request.StudentCoursesRequest;
import com.testinium.sgms.dto.request.StudentRequest;
import com.testinium.sgms.dto.response.GenericStudentResponse;
import com.testinium.sgms.dto.response.StudentResponse;

import java.util.List;

public interface StudentService {


    StudentResponse getStudentById(StudentRequest studentRequest);

    List<StudentResponse> getAllStudentsGrades();

    List<GenericStudentResponse> findAllStudents();

    GenericStudentResponse addNewStudent(AddStudentRequest studentRequest);

    StudentResponse assign(StudentCoursesRequest studentCourses);
}
