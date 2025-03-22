package com.example.SkillSphereBackEnd.controller;

import com.example.SkillSphereBackEnd.dto.CourseDTO;
import com.example.SkillSphereBackEnd.dto.InstructorDTO;
import com.example.SkillSphereBackEnd.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/instructors")
public class InstructorController {

    @Autowired
    private InstructorService instructorService;

    // Register a new instructor
    @PostMapping("/register")
    public ResponseEntity<InstructorDTO> registerInstructor(@RequestBody InstructorDTO instructorDTO) {
        InstructorDTO createdInstructor = instructorService.registerInstructor(instructorDTO);
        return new ResponseEntity<>(createdInstructor, HttpStatus.CREATED);
    }

    // Get instructor details
    @GetMapping("/{instructorId}")
    public ResponseEntity<InstructorDTO> getInstructor(@PathVariable Long instructorId) {
        InstructorDTO instructor = instructorService.getInstructorDetails(instructorId);
        return ResponseEntity.ok(instructor);
    }

    // Update instructor details
    @PutMapping("/{instructorId}")
    public ResponseEntity<InstructorDTO> updateInstructor(@PathVariable Long instructorId, @RequestBody InstructorDTO instructorDTO) {
        InstructorDTO updatedInstructor = instructorService.updateInstructorDetails(instructorId, instructorDTO);
        return ResponseEntity.ok(updatedInstructor);
    }

    // Create a new course
    @PostMapping("/{instructorId}/courses")
    public ResponseEntity<CourseDTO> createCourse(@PathVariable Long instructorId, @RequestBody CourseDTO courseDTO) {
        CourseDTO createdCourse = instructorService.createCourse(instructorId, courseDTO);
        return new ResponseEntity<>(createdCourse, HttpStatus.CREATED);
    }

    // Get all courses by instructor
    @GetMapping("/{instructorId}/courses")
    public ResponseEntity<List<CourseDTO>> getInstructorCourses(@PathVariable Long instructorId) {
        List<CourseDTO> courses = instructorService.getInstructorCourses(instructorId);
        return ResponseEntity.ok(courses);
    }

    // Update course details
    @PutMapping("/{instructorId}/courses/{courseId}")
    public ResponseEntity<CourseDTO> updateCourse(@PathVariable Long instructorId, @PathVariable Long courseId, @RequestBody CourseDTO courseDTO) {
        CourseDTO updatedCourse = instructorService.updateCourse(instructorId, courseId, courseDTO);
        return ResponseEntity.ok(updatedCourse);
    }

    // Delete a course
    @DeleteMapping("/{instructorId}/courses/{courseId}")
    public ResponseEntity<Void> deleteCourse(@PathVariable Long instructorId, @PathVariable Long courseId) {
        instructorService.deleteCourse(instructorId, courseId);
        return ResponseEntity.noContent().build();
    }
}
