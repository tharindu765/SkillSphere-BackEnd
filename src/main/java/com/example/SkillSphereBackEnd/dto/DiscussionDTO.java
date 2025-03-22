package com.example.SkillSphereBackEnd.dto;

import java.time.LocalDateTime;

public class DiscussionDTO {

    private Long id;
    private Long studentId;
    private Long instructorId;
    private Long courseId;
    private String message;
    private LocalDateTime timestamp;

    // Default constructor
    public DiscussionDTO() {
    }

    // Constructor with parameters
    public DiscussionDTO(Long id, Long studentId, Long instructorId, Long courseId, String message, LocalDateTime timestamp) {
        this.id = id;
        this.studentId = studentId;
        this.instructorId = instructorId;
        this.courseId = courseId;
        this.message = message;
        this.timestamp = timestamp;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public Long getInstructorId() {
        return instructorId;
    }

    public void setInstructorId(Long instructorId) {
        this.instructorId = instructorId;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
