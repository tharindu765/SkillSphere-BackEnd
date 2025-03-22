package com.example.SkillSphereBackEnd.controller;

import com.example.SkillSphereBackEnd.dto.DiscussionDTO;
import com.example.SkillSphereBackEnd.service.DiscussionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/discussions")
public class DiscussionController {

    @Autowired
    private DiscussionService discussionService;

    @PostMapping("/add")
    public ResponseEntity<DiscussionDTO> addDiscussion(@RequestBody DiscussionDTO discussionDTO) {
        return ResponseEntity.ok(discussionService.addDiscussion(discussionDTO));
    }

    @GetMapping("/course/{courseId}")
    public ResponseEntity<List<DiscussionDTO>> getDiscussionsByCourse(@PathVariable Long courseId) {
        return ResponseEntity.ok(discussionService.getDiscussionsByCourse(courseId));
    }

    @GetMapping("/student/{studentId}")
    public ResponseEntity<List<DiscussionDTO>> getDiscussionsByStudent(@PathVariable Long studentId) {
        return ResponseEntity.ok(discussionService.getDiscussionsByStudent(studentId));
    }

    @GetMapping("/instructor/{instructorId}")
    public ResponseEntity<List<DiscussionDTO>> getDiscussionsByInstructor(@PathVariable Long instructorId) {
        return ResponseEntity.ok(discussionService.getDiscussionsByInstructor(instructorId));
    }
}
