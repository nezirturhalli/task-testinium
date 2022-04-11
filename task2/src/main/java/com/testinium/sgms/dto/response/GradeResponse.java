package com.testinium.sgms.dto.response;

import com.testinium.sgms.entity.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GradeResponse {
    private Double midterm;
    private Double finalExam;
    private Double averageExam;
    private Status status;
}
