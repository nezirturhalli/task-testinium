package com.testinium.sgms.repository;

import com.testinium.sgms.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository
        extends JpaRepository<Student, Long> {
    Student findByStudentId(String studentId);

}
