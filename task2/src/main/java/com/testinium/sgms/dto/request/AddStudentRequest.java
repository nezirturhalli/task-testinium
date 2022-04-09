package com.testinium.sgms.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AddStudentRequest {

    @NotBlank
    private String studentId;

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;


}
