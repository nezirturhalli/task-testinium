package com.testinium.sgms.dto.request;

import com.testinium.sgms.entity.SchoolYear;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AddCourseRequest {
    @NotBlank
    private String courseCode;
    @NotBlank
    private String courseName;
    @NotNull
    private SchoolYear year;


}
