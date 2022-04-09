package com.testinium.sgms.repository;

import com.testinium.sgms.entity.Grade;
import com.testinium.sgms.entity.SchoolYear;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GradeRepository
        extends JpaRepository<Grade, Long> {
    Grade findGradeByStudentCourses_StudentIdAndStudentCourses_CourseCodeAndStudentCourses_Year(String studentId, String courseCode, SchoolYear schoolYear);

}
