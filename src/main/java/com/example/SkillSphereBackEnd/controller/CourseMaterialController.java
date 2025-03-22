package com.example.SkillSphereBackEnd.controller;

import com.example.SkillSphereBackEnd.dto.CourseMaterialDTO;
import com.example.SkillSphereBackEnd.service.CourseMaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/course-materials")
public class CourseMaterialController {

    private final CourseMaterialService courseMaterialService;

    @Autowired
    public CourseMaterialController(CourseMaterialService courseMaterialService) {
        this.courseMaterialService = courseMaterialService;
    }

    @PostMapping("/add")
    public ResponseEntity<CourseMaterialDTO> addCourseMaterial(@RequestBody CourseMaterialDTO courseMaterialDTO) {
        return ResponseEntity.ok(courseMaterialService.addCourseMaterial(courseMaterialDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CourseMaterialDTO> getCourseMaterialById(@PathVariable Long id) {
        return ResponseEntity.ok(courseMaterialService.getCourseMaterialById(id));
    }

    @GetMapping("/course/{courseId}")
    public ResponseEntity<List<CourseMaterialDTO>> getMaterialsByCourse(@PathVariable Long courseId) {
        return ResponseEntity.ok(courseMaterialService.getMaterialsByCourse(courseId));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCourseMaterial(@PathVariable Long id) {
        courseMaterialService.deleteCourseMaterial(id);
        return ResponseEntity.ok("Course Material deleted successfully");
    }
}
