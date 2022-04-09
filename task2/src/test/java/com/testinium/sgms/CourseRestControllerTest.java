//package com.testinium.sgms;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.testinium.sgms.dto.request.AddCourseRequest;
//import com.testinium.sgms.dto.response.GenericCoursesResponse;
//import com.testinium.sgms.entity.SchoolYear;
//import com.testinium.sgms.service.CourseService;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.params.ParameterizedTest;
//import org.junit.jupiter.params.provider.CsvFileSource;
//import org.mockito.Mockito;
//import org.modelmapper.ModelMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//
//import java.util.List;
//
//import static org.hamcrest.CoreMatchers.is;
//import static org.hamcrest.Matchers.hasSize;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@SpringBootTest(
//        classes = Task2Application.class,
//        webEnvironment = SpringBootTest.WebEnvironment.MOCK
//)
//@AutoConfigureMockMvc
//class CourseRestControllerTest {
//    @Autowired
//    MockMvc mockMvc;
//
//    @Autowired
//    ModelMapper modelMapper;
//
//    @Autowired
//    ObjectMapper objectMapper;
//
//    @MockBean
//    CourseService courseService;
//
//    @Test
//    void getAllCoursesShouldReturnOk() throws Throwable {
//        var course1 = new GenericCoursesResponse();
//        course1.setCourseCode("MATH");
//        course1.setCourseName("Mathematics");
//        course1.setYear(SchoolYear.ACTIVE);
//        var course2 = new GenericCoursesResponse();
//        course2.setCourseCode("PHY");
//        course2.setCourseName("Physics");
//        course2.setYear(SchoolYear.PASSIVE);
//
//        Mockito.when(courseService.findAllCourses())
//                .thenReturn(List.of(course1, course2));
//
//        mockMvc.perform(get("/courses/getAllCourses")
//                        .accept(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$", hasSize(2)))
//                .andExpect(jsonPath("$.length()", is(2)))
//                .andExpect(jsonPath("$[0].courseCode", is("MATH")))
//                .andExpect(jsonPath("$[1].courseCode", is("PHY")));
//    }
//
//    @ParameterizedTest
//    @CsvFileSource(resources = "course.csv")
//    void addNewCourseShouldReturnOk(
//            String courseCode,
//            String courseName,
//            String year
//    ) throws Throwable {
//        var request = new AddCourseRequest();
//        request.setCourseCode(courseCode);
//        request.setCourseName(courseName);
//        request.setYear(SchoolYear.valueOf(year));
//
//        var response = modelMapper.map(request, GenericCoursesResponse.class);
//
//        Mockito.when(courseService.addNewCourse(request))
//                .thenReturn(response);
//        mockMvc.perform(
//                        post("/courses/new")
//                                .accept(MediaType.APPLICATION_JSON)
//                                .contentType(MediaType.APPLICATION_JSON)
//                                .content(objectMapper.writeValueAsString(request))
//                )
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.courseCode", is(courseCode)))
//                .andExpect(jsonPath("$.courseName", is(courseName)))
//                .andExpect(jsonPath("$.year", is(year)));
//
//    }
//
//}
