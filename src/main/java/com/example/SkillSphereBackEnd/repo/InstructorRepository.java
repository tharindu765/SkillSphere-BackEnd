package com.example.SkillSphereBackEnd.repo;


import com.example.SkillSphereBackEnd.entity.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstructorRepository extends JpaRepository<Instructor, Long> {
}
