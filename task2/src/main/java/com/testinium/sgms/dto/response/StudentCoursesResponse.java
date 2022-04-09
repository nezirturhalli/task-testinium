package com.testinium.sgms.dto.response;

import com.testinium.sgms.entity.SchoolYear;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentCoursesResponse {
    private String studentId;
    private String courseCode;
    private SchoolYear schoolYear;
}
