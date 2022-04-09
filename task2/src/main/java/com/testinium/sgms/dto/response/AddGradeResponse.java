package com.testinium.sgms.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AddGradeResponse {
    private StudentCoursesResponse studentCoursesResponse;
    private GradeResponse gradeResponse;
}
