package com.testinium.sgms.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.testinium.sgms.entity.SchoolYear;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CourseResponse {
    private String courseCode;
    @JsonIgnore
    private String courseName;
    private SchoolYear schoolYear;
    private GradeResponse response;
}
