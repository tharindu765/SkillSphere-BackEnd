package com.example.SkillSphereBackEnd.repo;

import com.example.SkillSphereBackEnd.entity.Certificate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CertificateRepository extends JpaRepository<Certificate, Long> {
    List<Certificate> findByStudentId(Long studentId); // Find certificates by student
    List<Certificate> findByCourseId(Long courseId); // Find certificates by course
}
