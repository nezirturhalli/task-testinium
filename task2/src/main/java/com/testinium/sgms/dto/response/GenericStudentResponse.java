package com.testinium.sgms.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GenericStudentResponse {
    private String studentId;
    private String firstName;
    private String lastName;

}
