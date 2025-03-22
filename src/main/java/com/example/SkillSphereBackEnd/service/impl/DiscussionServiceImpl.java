package com.example.SkillSphereBackEnd.service.impl;

import com.example.SkillSphereBackEnd.dto.DiscussionDTO;
import com.example.SkillSphereBackEnd.entity.Discussion;
import com.example.SkillSphereBackEnd.entity.Course;
import com.example.SkillSphereBackEnd.entity.Instructor;
import com.example.SkillSphereBackEnd.entity.Student;
import com.example.SkillSphereBackEnd.repo.CourseRepository;
import com.example.SkillSphereBackEnd.repo.DiscussionRepository;
import com.example.SkillSphereBackEnd.repo.InstructorRepository;
import com.example.SkillSphereBackEnd.repo.StudentRepository;
import com.example.SkillSphereBackEnd.service.DiscussionService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DiscussionServiceImpl implements DiscussionService {

    @Autowired
    private DiscussionRepository discussionRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private InstructorRepository instructorRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public DiscussionDTO addDiscussion(DiscussionDTO discussionDTO) {
        Optional<Student> studentOpt = studentRepository.findById(discussionDTO.getStudentId());
        Optional<Instructor> instructorOpt = instructorRepository.findById(discussionDTO.getInstructorId());
        Optional<Course> courseOpt = courseRepository.findById(discussionDTO.getCourseId());  // Add this line

        if (studentOpt.isPresent() && instructorOpt.isPresent()) {
            Discussion discussion = new Discussion();
            discussion.setStudent(studentOpt.get());
            discussion.setInstructor(instructorOpt.get());
            discussion.setCourse(courseOpt.get());
            discussion.setMessage(discussionDTO.getMessage());
            discussion.setTimestamp(LocalDateTime.now());

            discussion = discussionRepository.save(discussion);
            return modelMapper.map(discussion, DiscussionDTO.class);
        } else {
            throw new RuntimeException("Invalid student or instructor ID");
        }
    }

    @Override
    public List<DiscussionDTO> getDiscussionsByCourse(Long courseId) {
        List<Discussion> discussions = discussionRepository.findByCourseId(courseId);
        return discussions.stream()
                .map(discussion -> modelMapper.map(discussion, DiscussionDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<DiscussionDTO> getDiscussionsByStudent(Long studentId) {
        List<Discussion> discussions = discussionRepository.findByStudentId(studentId);
        return discussions.stream()
                .map(discussion -> modelMapper.map(discussion, DiscussionDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<DiscussionDTO> getDiscussionsByInstructor(Long instructorId) {
        List<Discussion> discussions = discussionRepository.findByInstructorId(instructorId);
        return discussions.stream()
                .map(discussion -> modelMapper.map(discussion, DiscussionDTO.class))
                .collect(Collectors.toList());
    }
}
