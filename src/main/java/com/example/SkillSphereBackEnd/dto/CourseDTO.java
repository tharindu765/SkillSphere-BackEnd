package com.example.SkillSphereBackEnd.dto;

import com.example.SkillSphereBackEnd.enums.CourseCategory;
import java.util.List;

public class CourseDTO {

    private Long id;
    private String title;
    private String description;
    private Double price;
    private CourseCategory category;
    private Long instructorId; // Instructor ID, not the whole Instructor object
    private List<Long> materialsIds; // List of material IDs

    // Constructors
    public CourseDTO() {}

    public CourseDTO(Long id, String title, String description, Double price, CourseCategory category, Long instructorId, List<Long> materialsIds) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.price = price;
        this.category = category;
        this.instructorId = instructorId;
        this.materialsIds = materialsIds;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public CourseCategory getCategory() {
        return category;
    }

    public void setCategory(CourseCategory category) {
        this.category = category;
    }

    public Long getInstructorId() {
        return instructorId;
    }

    public void setInstructorId(Long instructorId) {
        this.instructorId = instructorId;
    }

    public List<Long> getMaterialsIds() {
        return materialsIds;
    }

    public void setMaterialsIds(List<Long> materialsIds) {
        this.materialsIds = materialsIds;
    }

    @Override
    public String toString() {
        return "CourseDTO{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", category=" + category +
                ", instructorId=" + instructorId +
                ", materialsIds=" + materialsIds +
                '}';
    }
}
