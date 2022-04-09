package com.testinium.sgms.dto.request;

import com.testinium.sgms.entity.SchoolYear;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentCoursesRequest {
    @NotBlank
    private String studentId;
    @NotBlank
    private String courseCode;
    @NotNull
    private SchoolYear schoolYear;
}
