package com.testinium.sgms.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentCoursesRequest {
    @NotBlank
    private String studentId;
    @NotBlank
    private String courseCode;
}
