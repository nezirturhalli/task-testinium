package com.testinium.sgms.service.impl;

import com.testinium.sgms.dto.request.AddCourseRequest;
import com.testinium.sgms.dto.response.GenericCoursesResponse;
import com.testinium.sgms.entity.Course;
import com.testinium.sgms.repository.CourseRepository;
import com.testinium.sgms.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {
    private final CourseRepository courseRepository;
    private final ModelMapper modelMapper;

    @Override
    public GenericCoursesResponse addNewCourse(AddCourseRequest courseRequest) {
        var course = modelMapper.map(courseRequest, Course.class);
        var saveCourse= courseRepository.save(course);
        return modelMapper.map(saveCourse, GenericCoursesResponse.class);
    }


    @Override
    public List<GenericCoursesResponse> findAllCourses() {
        return courseRepository.findAll()
                .stream()
                .map(course -> modelMapper.map(course, GenericCoursesResponse.class))
                .distinct()
                .toList();
    }
}
