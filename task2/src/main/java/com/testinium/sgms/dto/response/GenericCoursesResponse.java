package com.testinium.sgms.dto.response;

import com.testinium.sgms.entity.SchoolYear;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GenericCoursesResponse {
    private String courseCode;
    private String courseName;
    private SchoolYear year;
}
