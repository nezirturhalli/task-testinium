package com.testinium.sgms.controller;

import com.testinium.sgms.dto.request.AddCourseRequest;
import com.testinium.sgms.dto.response.GenericCoursesResponse;
import com.testinium.sgms.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;

import java.util.List;

@RestController
@RequestScope
@CrossOrigin
@RequestMapping("/courses")
@RequiredArgsConstructor
public class CourseRestController {
    private final CourseService courseService;

    @PostMapping("/new")
    public GenericCoursesResponse addNewCourse(@RequestBody @Validated AddCourseRequest request) {
        return courseService.addNewCourse(request);
    }

    @GetMapping("/getAllCourses")
    public List<GenericCoursesResponse> getAllCourses() {
        return courseService.findAllCourses();
    }

}
