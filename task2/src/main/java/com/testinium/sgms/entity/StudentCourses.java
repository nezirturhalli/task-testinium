package com.testinium.sgms.entity;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class StudentCourses {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String studentId;

    @Column(nullable = false)
    private String courseCode;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private SchoolYear year = SchoolYear.ACTIVE;


    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinTable(name = "student_courses_grade",
            joinColumns = @JoinColumn(name = "student_courses_id"),
            inverseJoinColumns = @JoinColumn(name = "grade_id"))
    private Grade grade;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        StudentCourses that = (StudentCourses) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
