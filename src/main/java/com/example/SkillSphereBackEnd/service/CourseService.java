package com.example.SkillSphereBackEnd.service;

import com.example.SkillSphereBackEnd.dto.CourseDTO;
import com.example.SkillSphereBackEnd.enums.CourseCategory;

import java.util.List;
import java.util.Optional;

public interface CourseService {
    List<CourseDTO> getAllCourses(CourseCategory category); // Get all courses (optional category filter)
    Optional<CourseDTO> getCourseById(Long courseId); // Get course details
    CourseDTO createCourse(Long instructorId, CourseDTO courseDTO); // Create a new course
    CourseDTO updateCourse(Long courseId, CourseDTO courseDTO); // Update course details
    void deleteCourse(Long courseId); // Delete a course
}
