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
public class AddGradeRequest {

    @NotNull
    private String studentId;
    @NotNull
    private Double midterm;
    @NotNull
    private Double finalExam;
    @NotBlank
    private String courseCode;
    @NotNull
    private SchoolYear year;


}
