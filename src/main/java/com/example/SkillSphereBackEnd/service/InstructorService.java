package com.example.SkillSphereBackEnd.service;

import com.example.SkillSphereBackEnd.dto.CourseDTO;
import com.example.SkillSphereBackEnd.dto.InstructorDTO;
import java.util.List;

public interface InstructorService {
    // Register an instructor
    InstructorDTO registerInstructor(InstructorDTO instructorDTO);

    // Get instructor details
    InstructorDTO getInstructorDetails(Long instructorId);

    // Update instructor profile details
    InstructorDTO updateInstructorDetails(Long instructorId, InstructorDTO instructorDTO);

    // Instructor creates a course
    CourseDTO createCourse(Long instructorId, CourseDTO courseDTO);

    // Get all courses created by the instructor
    List<CourseDTO> getInstructorCourses(Long instructorId);

    // Update course details
    CourseDTO updateCourse(Long instructorId, Long courseId, CourseDTO courseDTO);

    // Delete a course
    void deleteCourse(Long instructorId, Long courseId);
}
