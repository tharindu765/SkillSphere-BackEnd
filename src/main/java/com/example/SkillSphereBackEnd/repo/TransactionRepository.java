package com.example.SkillSphereBackEnd.repo;

import com.example.SkillSphereBackEnd.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    List<Transaction> findByStudentId(Long studentId); // Find transactions by student
    List<Transaction> findByCourseId(Long courseId); // Find transactions by course
}
