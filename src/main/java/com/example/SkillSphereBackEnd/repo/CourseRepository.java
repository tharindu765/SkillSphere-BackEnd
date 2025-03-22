package com.example.SkillSphereBackEnd.repo;

import com.example.SkillSphereBackEnd.entity.Course;
import com.example.SkillSphereBackEnd.entity.Instructor;
import com.example.SkillSphereBackEnd.enums.CourseCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    List<Course> findByCategory(CourseCategory category); // Find courses by category
    List<Course> findByInstructorId(Long instructorId); // Find courses by instructor
    List<Course> findByInstructor(Instructor instructor);
}
