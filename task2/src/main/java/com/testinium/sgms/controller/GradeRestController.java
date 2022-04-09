package com.testinium.sgms.controller;

import com.testinium.sgms.dto.request.AddGradeRequest;
import com.testinium.sgms.dto.response.AddGradeResponse;
import com.testinium.sgms.service.GradeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;

@RestController
@RequestScope
@CrossOrigin
@RequestMapping("/grades")
@RequiredArgsConstructor
public class GradeRestController {
    private final GradeService gradeService;


    @PostMapping("/new")
    public AddGradeResponse addNewGradeForOneCourse(@RequestBody AddGradeRequest gradeRequest) {
        return gradeService.addCourseGrade(gradeRequest);
    }

}
