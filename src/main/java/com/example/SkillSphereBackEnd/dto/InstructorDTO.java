package com.example.SkillSphereBackEnd.dto;

import com.example.SkillSphereBackEnd.enums.UserRole;
import lombok.*;

public class InstructorDTO extends UserDTO {
    private String bio;
    private Double earnings;


    public InstructorDTO() {
        this.earnings = 0.0;
    }

    public InstructorDTO(Long id, String fullName, String email, String password, UserRole role) {
        super(id, fullName, email, password, role);

    }

    public InstructorDTO(String bio, Double earnings) {
        this.bio = bio;
        this.earnings = earnings;
    }

    public InstructorDTO(Long id, String fullName, String email, String password, UserRole role, String bio, Double earnings) {
        super(id, fullName, email, password, role);
        this.bio = bio;
        this.earnings = earnings;
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

    @Override
    public String toString() {
        return "InstructorDTO{" +
                "bio='" + bio + '\'' +
                ", earnings=" + earnings +
                '}';
    }
}
