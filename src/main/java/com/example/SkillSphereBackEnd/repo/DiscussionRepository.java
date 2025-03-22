package com.example.SkillSphereBackEnd.repo;

import com.example.SkillSphereBackEnd.entity.Discussion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DiscussionRepository extends JpaRepository<Discussion, Long> {
    List<Discussion> findByCourseId(Long courseId);
    List<Discussion> findByStudentId(Long studentId);
    List<Discussion> findByInstructorId(Long instructorId);
}
