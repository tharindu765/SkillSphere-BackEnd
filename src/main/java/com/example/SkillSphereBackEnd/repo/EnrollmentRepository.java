package com.example.SkillSphereBackEnd.repo;

import com.example.SkillSphereBackEnd.entity.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {
    List<Enrollment> findByStudentId(Long studentId); // Find enrollments by student
    List<Enrollment> findByCourseId(Long courseId); // Find enrollments by course
    Optional<Enrollment> findByStudentIdAndCourseId(Long studentId, Long courseId); // Check if a student is enrolled in a course
}
