package com.example.SkillSphereBackEnd.dto;

public class CourseMaterialDTO {
    private Long id;
    private String type; // Video, PDF, Quiz
    private String url; // Cloud storage link
    private Long courseId; // Reference to the course

    public CourseMaterialDTO() {
    }

    public CourseMaterialDTO(Long id, String type, String url, Long courseId) {
        this.id = id;
        this.type = type;
        this.url = url;
        this.courseId = courseId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }
}
