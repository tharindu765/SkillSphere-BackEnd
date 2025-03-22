package com.example.SkillSphereBackEnd.dto;

import java.time.LocalDateTime;

public class EnrollmentDTO {
    private Long id;
    private Long studentId;
    private Long courseId;
    private LocalDateTime enrollmentDate;
    private Boolean completed;

    // ✅ No-Args Constructor
    public EnrollmentDTO() {
        this.enrollmentDate = LocalDateTime.now();
        this.completed = false;
    }

    // ✅ Constructor with Student & Course IDs
    public EnrollmentDTO(Long studentId, Long courseId) {
        this.studentId = studentId;
        this.courseId = courseId;
        this.enrollmentDate = LocalDateTime.now();
        this.completed = false;
    }

    // ✅ Constructor with All Fields
    public EnrollmentDTO(Long id, Long studentId, Long courseId, LocalDateTime enrollmentDate, Boolean completed) {
        this.id = id;
        this.studentId = studentId;
        this.courseId = courseId;
        this.enrollmentDate = enrollmentDate;
        this.completed = completed;
    }

    // ✅ Getters and Setters
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

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public LocalDateTime getEnrollmentDate() {
        return enrollmentDate;
    }

    public void setEnrollmentDate(LocalDateTime enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    // ✅ toString() Method
    @Override
    public String toString() {
        return "EnrollmentDTO{" +
                "id=" + id +
                ", studentId=" + studentId +
                ", courseId=" + courseId +
                ", enrollmentDate=" + enrollmentDate +
                ", completed=" + completed +
                '}';
    }
}
