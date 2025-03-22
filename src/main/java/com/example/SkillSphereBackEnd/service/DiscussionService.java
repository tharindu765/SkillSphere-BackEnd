package com.example.SkillSphereBackEnd.service;

import com.example.SkillSphereBackEnd.dto.DiscussionDTO;

import java.util.List;

public interface DiscussionService {
    DiscussionDTO addDiscussion(DiscussionDTO discussionDTO);
    List<DiscussionDTO> getDiscussionsByCourse(Long courseId);
    List<DiscussionDTO> getDiscussionsByStudent(Long studentId);
    List<DiscussionDTO> getDiscussionsByInstructor(Long instructorId);
}
