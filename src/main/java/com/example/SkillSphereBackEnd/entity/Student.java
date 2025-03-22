package com.example.SkillSphereBackEnd.entity;

import com.example.SkillSphereBackEnd.enums.UserRole;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "students")
public class Student extends User {

    @Column(name = "progress_tracking", nullable = false)
    private Double progress = 0.0; // Percentage

    @Column(name = "certificates_earned")
    private Integer certificatesEarned = 0;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private List<Enrollment> enrollments = new ArrayList<>();

    public Student() {
        this.progress =  0.0; // ✅ Ensure default
        this.certificatesEarned =  0; // ✅ Ensure default
    }

    public Student(Long id, String email, String password, String fullName, UserRole role) {
        super(id, email, password, fullName, role);
    }

    public Student(Double progress, Integer certificatesEarned, List<Enrollment> enrollments) {
        this.progress = progress;
        this.certificatesEarned = certificatesEarned;
        this.enrollments = enrollments;
    }

    public Student(Long id, String email, String password, String fullName, UserRole role, Double progress, Integer certificatesEarned, List<Enrollment> enrollments) {
        super(id, email, password, fullName, role);
        this.progress = (progress != null) ? progress : 0.0; // ✅ Ensure default
        this.certificatesEarned = (certificatesEarned != null) ? certificatesEarned : 0; // ✅ Ensure default
        this.enrollments = enrollments;
    }

    public Double getProgress() {
        return progress;
    }

    public void setProgress(Double progress) {
        this.progress =(progress != null) ? progress : 0.0; // ✅ Ensure default;
    }

    public Integer getCertificatesEarned() {
        return certificatesEarned;
    }

    public void setCertificatesEarned(Integer certificatesEarned) {
        this.certificatesEarned =(certificatesEarned != null) ? certificatesEarned : 0; // ✅ Ensure default
    }

    public List<Enrollment> getEnrollments() {
        return enrollments;
    }

    public void setEnrollments(List<Enrollment> enrollments) {
        this.enrollments = enrollments;
    }

    @Override
    public String toString() {
        return "Student{" +
                "progress=" + progress +
                ", certificatesEarned=" + certificatesEarned +
                ", enrollments=" + enrollments +
                '}';
    }
}
