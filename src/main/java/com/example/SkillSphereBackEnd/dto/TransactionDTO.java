package com.example.SkillSphereBackEnd.dto;

import java.time.LocalDateTime;

public class TransactionDTO {

    private Long id;
    private Long studentId;
    private Long courseId;
    private Double amount;
    private LocalDateTime timestamp;

    // Default constructor
    public TransactionDTO() {
        this.timestamp = LocalDateTime.now();
    }

    // Constructor to initialize all fields
    public TransactionDTO(Long id, Long studentId, Long courseId, Double amount, LocalDateTime timestamp) {
        this.id = id;
        this.studentId = studentId;
        this.courseId = courseId;
        this.amount = amount;
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

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
