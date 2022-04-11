package com.testinium.sgms.repository;

import com.testinium.sgms.entity.Grade;
import com.testinium.sgms.entity.SchoolYear;
import com.testinium.sgms.entity.StudentCourses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface
StudentCoursesRepository extends
        JpaRepository<StudentCourses, Long> {
    StudentCourses findByStudentId(String studentId);

    StudentCourses findByStudentIdAndCourseCodeAndYear(String studentId, String courseCode, SchoolYear schoolYear);


}
