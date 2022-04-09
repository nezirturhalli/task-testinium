package com.testinium.sgms.repository;

import com.testinium.sgms.entity.StudentCourses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface
StudentCoursesRepository extends
        JpaRepository<StudentCourses, Long> {
    StudentCourses findByStudentId(String studentId);



}
