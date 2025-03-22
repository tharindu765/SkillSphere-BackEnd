package com.example.SkillSphereBackEnd.dto;

import com.example.SkillSphereBackEnd.enums.UserRole;
import lombok.*;

import java.util.List;

public class StudentDTO extends UserDTO {
    private Double progress;
    private Integer certificatesEarned;
    private List<Long> enrolledCourseIds; // List of course IDs the student is enrolled in

    // Constructors
    public StudentDTO() {
        this.progress = 0.0;
        this.certificatesEarned = 0;
    }

    public StudentDTO(Long id, String fullName, String email, String password, UserRole role) {
        super(id, fullName, email, password, role);
    }

    public StudentDTO(Double progress, Integer certificatesEarned) {
        this.progress = progress;
        this.certificatesEarned = certificatesEarned;
    }

    public StudentDTO(Long id, String fullName, String email, String password, UserRole role, Double progress, Integer certificatesEarned, List<Long> enrolledCourseIds) {
        super(id, fullName, email, password, role);
        this.progress = (progress != null) ? progress : 0.0; // ✅ Ensure default
        this.certificatesEarned = (certificatesEarned != null) ? certificatesEarned : 0; // ✅ Ensure default
        this.enrolledCourseIds = enrolledCourseIds;
    }

    // Getters and Setters
    public Double getProgress() {
        return progress;
    }

    public void setProgress(Double progress) {
        this.progress = (progress != null) ? progress : 0.0; // ✅ Ensure default;
    }

    public Integer getCertificatesEarned() {
        return certificatesEarned;
    }

    public void setCertificatesEarned(Integer certificatesEarned) {
        this.certificatesEarned = (certificatesEarned != null) ? certificatesEarned : 0; // ✅ Ensure default
    }

    public List<Long> getEnrolledCourseIds() {
        return enrolledCourseIds;
    }

    public void setEnrolledCourseIds(List<Long> enrolledCourseIds) {
        this.enrolledCourseIds = enrolledCourseIds;
    }

    @Override
    public String toString() {
        return "StudentDTO{" +
                "id=" + getId() +
                ", email='" + getEmail() + '\'' +
                ", fullName='" + getFullName() + '\'' +
                ", password='" + getPassword() + '\'' +
                ", progress=" + progress +
                ", certificatesEarned=" + certificatesEarned +
                ", enrolledCourseIds=" + enrolledCourseIds +
                '}';
    }
}
