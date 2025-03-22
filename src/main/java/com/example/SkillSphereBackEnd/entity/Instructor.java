package com.example.SkillSphereBackEnd.entity;

import com.example.SkillSphereBackEnd.enums.UserRole;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "instructors")
public class Instructor extends User {
    @Column(nullable = false)
    private String bio;

    @Column(name = "earnings", nullable = false)
    private Double earnings = 0.0;

    @OneToMany(mappedBy = "instructor")
    private List<Course> courses;

    public Instructor() {
        this.earnings = 0.0;
    }

    public Instructor(Long id, String email, String password, String fullName, UserRole role) {
        super(id, email, password, fullName, role);
        this.earnings = 0.0;
    }


    public Instructor(String bio, Double earnings, List<Course> courses) {
        this.bio = bio;
        this.earnings = earnings;
        this.courses = courses;
    }

    public Instructor(Long id, String email, String password, String fullName, UserRole role, String bio, Double earnings, List<Course> courses) {
        super(id, email, password, fullName, role);
        this.bio = bio;
        this.earnings = earnings;
        this.courses = courses;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public Double getEarnings() {
        return earnings;
    }

    public void setEarnings(Double earnings) {
        this.earnings = earnings;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    @Override
    public String toString() {
        return "Instructor{" +
                "bio='" + bio + '\'' +
                ", earnings=" + earnings +
                ", courses=" + courses +
                '}';
    }
}

