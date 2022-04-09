package com.testinium.sgms.service.impl;

import com.testinium.sgms.dto.request.AddGradeRequest;
import com.testinium.sgms.dto.response.AddGradeResponse;
import com.testinium.sgms.entity.Grade;
import com.testinium.sgms.repository.GradeRepository;
import com.testinium.sgms.service.GradeService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GradeServiceImpl implements GradeService {

    private final GradeRepository gradeRepository;
    private final ModelMapper modelMapper;

    @Override
    public AddGradeResponse addCourseGrade(AddGradeRequest gradeRequest) {
        var grade = gradeRepository
                .findGradeByStudentCourses_StudentIdAndStudentCourses_CourseCodeAndStudentCourses_Year
                        (gradeRequest.getStudentId(), gradeRequest.getCourseCode(), gradeRequest.getYear());
        if (grade == null) {
            grade = modelMapper.map(gradeRequest, Grade.class);
        }
        grade.setMidterm(gradeRequest.getMidterm());
        grade.setFinalExam(gradeRequest.getFinalExam());
        grade.setAverageExam((gradeRequest.getMidterm() + gradeRequest.getFinalExam()) / 2);
        return modelMapper.map(gradeRepository.saveAndFlush(grade), AddGradeResponse.class);

    }
}
