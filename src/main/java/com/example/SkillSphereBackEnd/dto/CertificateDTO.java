package com.example.SkillSphereBackEnd.dto;

import java.time.LocalDateTime;

public class CertificateDTO {
    private Long id;
    private Long studentId;
    private Long courseId;
    private String certificateUrl;
    private LocalDateTime issuedAt;

    // Constructors
    public CertificateDTO() {
    }

    public CertificateDTO(Long id, Long studentId, Long courseId, String certificateUrl, LocalDateTime issuedAt) {
        this.id = id;
        this.studentId = studentId;
        this.courseId = courseId;
        this.certificateUrl = certificateUrl;
        this.issuedAt = issuedAt;
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

    public String getCertificateUrl() {
        return certificateUrl;
    }

    public void setCertificateUrl(String certificateUrl) {
        this.certificateUrl = certificateUrl;
    }

    public LocalDateTime getIssuedAt() {
        return issuedAt;
    }

    public void setIssuedAt(LocalDateTime issuedAt) {
        this.issuedAt = issuedAt;
    }
}
