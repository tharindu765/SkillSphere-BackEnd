package com.example.SkillSphereBackEnd.service;

import com.example.SkillSphereBackEnd.dto.EnrollmentDTO;

import java.util.List;

public interface EnrollmentService {
    EnrollmentDTO enrollStudent(Long studentId, Long courseId); // Enroll a student in a course
    List<EnrollmentDTO> getEnrollmentsByStudent(Long studentId); // Get enrollments of a student
    List<EnrollmentDTO> getEnrollmentsByCourse(Long courseId); // Get all students enrolled in a course
    void markCourseCompleted(Long enrollmentId); // Mark course as completed
}
