package com.testinium.sgms.service;

import com.testinium.sgms.dto.request.AddStudentRequest;
import com.testinium.sgms.dto.request.GenericGradeRequest;
import com.testinium.sgms.dto.request.StudentCoursesRequest;
import com.testinium.sgms.dto.response.GenericStudentResponse;
import com.testinium.sgms.dto.response.StudentResponse;

import java.util.List;

public interface StudentService {


        StudentResponse getStudentById(GenericGradeRequest request);


        List<StudentResponse> getAllStudentsGrades();


    List<GenericStudentResponse> getAllStudents();

    GenericStudentResponse addNewStudent(AddStudentRequest studentRequest);

    StudentResponse assign(StudentCoursesRequest studentCourses);
}
