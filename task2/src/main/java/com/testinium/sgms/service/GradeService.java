package com.testinium.sgms.service;

import com.testinium.sgms.dto.request.AddGradeRequest;
import com.testinium.sgms.dto.response.AddGradeResponse;

public interface GradeService {

    AddGradeResponse addCourseGrade(AddGradeRequest gradeRequest);
}
