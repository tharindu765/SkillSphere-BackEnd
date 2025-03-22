package com.example.SkillSphereBackEnd.service;

import com.example.SkillSphereBackEnd.dto.CourseDTO;
import com.example.SkillSphereBackEnd.dto.EnrollmentDTO;
import com.example.SkillSphereBackEnd.dto.StudentDTO;

import java.util.List;

public interface StudentService {
    StudentDTO registerStudent(StudentDTO studentDTO);
    StudentDTO getStudentDetails(Long studentId);
    EnrollmentDTO enrollInCourse(Long studentId, Long courseId);
    List<CourseDTO> getEnrolledCourses(Long studentId);
    Double getProgress(Long studentId);
    Integer getCertificatesEarned(Long studentId);
}
