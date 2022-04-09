package com.testinium.sgms.repository;

import com.testinium.sgms.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends
        JpaRepository<Course, Long> {
    Course findByCode(String courseCode);

}
