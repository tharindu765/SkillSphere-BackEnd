package com.example.SkillSphereBackEnd.controller;

import com.example.SkillSphereBackEnd.dto.CourseDTO;
import com.example.SkillSphereBackEnd.dto.StudentDTO;
import com.example.SkillSphereBackEnd.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    // ✅ Register Student
    @PostMapping("/register")
    public ResponseEntity<StudentDTO> registerStudent(@RequestBody StudentDTO studentDTO) {
        StudentDTO createdStudent = studentService.registerStudent(studentDTO);
        return new ResponseEntity<>(createdStudent, HttpStatus.CREATED);
    }

    // ✅ Get Student Details
    @GetMapping("/{studentId}")
    public ResponseEntity<StudentDTO> getStudent(@PathVariable Long studentId) {
        StudentDTO student = studentService.getStudentDetails(studentId);
        return ResponseEntity.ok(student);
    }

    // ✅ Enroll in a Course
    @PostMapping("/{studentId}/courses/{courseId}/enroll")
    public ResponseEntity<String> enrollInCourse(@PathVariable Long studentId, @PathVariable Long courseId) {
        studentService.enrollInCourse(studentId, courseId);
        return ResponseEntity.ok("Enrollment successful!");
    }

    // ✅ Get Enrolled Courses
    @GetMapping("/{studentId}/courses")
    public ResponseEntity<List<CourseDTO>> getEnrolledCourses(@PathVariable Long studentId) {
        List<CourseDTO> enrolledCourses = studentService.getEnrolledCourses(studentId);
        return ResponseEntity.ok(enrolledCourses);
    }

    // ✅ Track Course Progress
    @GetMapping("/{studentId}/progress")
    public ResponseEntity<Double> trackProgress(@PathVariable Long studentId) {
        Double progress = studentService.getProgress(studentId);
        return ResponseEntity.ok(progress);
    }

    // ✅ Get Certificates Earned
    @GetMapping("/{studentId}/certificates")
    public ResponseEntity<Integer> getCertificates(@PathVariable Long studentId) {
        Integer certificates = studentService.getCertificatesEarned(studentId);
        return ResponseEntity.ok(certificates);
    }
}
