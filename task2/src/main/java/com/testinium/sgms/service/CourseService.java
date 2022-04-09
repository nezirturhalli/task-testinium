package com.testinium.sgms.service;

import com.testinium.sgms.dto.request.AddCourseRequest;
import com.testinium.sgms.dto.response.GenericCoursesResponse;

import java.util.List;

public interface CourseService {

    GenericCoursesResponse addNewCourse(AddCourseRequest courseRequest);

    List<GenericCoursesResponse> findAllCourses();
}
