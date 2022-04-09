package com.testinium.sgms;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.testinium.sgms.dto.request.AddStudentRequest;
import com.testinium.sgms.dto.response.GenericStudentResponse;
import com.testinium.sgms.service.StudentService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(
        classes = Task2Application.class,
        webEnvironment = SpringBootTest.WebEnvironment.MOCK
)
@AutoConfigureMockMvc
class StudentRestControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    ObjectMapper objectMapper;

    @MockBean
    StudentService studentService;


    @Test
    void getAllStudentsShouldReturnOk() throws Throwable {
        var student1 = new GenericStudentResponse();
        student1.setStudentId("12312312");
        student1.setFirstName("Test");
        student1.setLastName("Test");

        var student2 = new GenericStudentResponse();
        student2.setStudentId("12312342");
        student2.setFirstName("Test2");
        student2.setLastName("Test2");

        Mockito.when(studentService.getAllStudents())
                .thenReturn(List.of(student1, student2));

        mockMvc.perform(get("/students")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$.length()", is(2)))
                .andExpect(jsonPath("$[0].studentId", is("12312312")))
                .andExpect(jsonPath("$[1].studentId", is("12312342")));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "student.csv")
    void addNewStudentShouldReturnOk(
            String studentId,
            String firstName,
            String lastName
    ) throws Throwable {

        var request = new AddStudentRequest();
        request.setStudentId(studentId);
        request.setFirstName(firstName);
        request.setLastName(lastName);

        var response = modelMapper.map(request, GenericStudentResponse.class);

        Mockito.when(studentService.addNewStudent(request))
                .thenReturn(response);

        mockMvc.perform(
                        post("/students/new")
                                .accept(MediaType.APPLICATION_JSON)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(request))
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.studentId", is(studentId)))
                .andExpect(jsonPath("$.firstName", is(firstName)))
                .andExpect(jsonPath("$.lastName", is(lastName)));
    }
}

