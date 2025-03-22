package com.example.SkillSphereBackEnd.service.impl;

import com.example.SkillSphereBackEnd.dto.CourseDTO;
import com.example.SkillSphereBackEnd.entity.Course;
import com.example.SkillSphereBackEnd.entity.Instructor;
import com.example.SkillSphereBackEnd.enums.CourseCategory;
import com.example.SkillSphereBackEnd.repo.CourseRepository;
import com.example.SkillSphereBackEnd.repo.InstructorRepository;
import com.example.SkillSphereBackEnd.service.CourseService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private InstructorRepository instructorRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<CourseDTO> getAllCourses(CourseCategory category) {
        List<Course> courses;
        if (category != null) {
            courses = courseRepository.findByCategory(category);
        } else {
            courses = courseRepository.findAll();
        }
        return courses.stream()
                .map(course -> modelMapper.map(course, CourseDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<CourseDTO> getCourseById(Long courseId) {
        return courseRepository.findById(courseId)
                .map(course -> modelMapper.map(course, CourseDTO.class));
    }

    @Override
    public CourseDTO createCourse(Long instructorId, CourseDTO courseDTO) {
        Optional<Instructor> instructorOpt = instructorRepository.findById(instructorId);
        if (instructorOpt.isEmpty()) {
            throw new RuntimeException("Instructor not found with ID: " + instructorId);
        }

        Instructor instructor = instructorOpt.get();
        Course course = modelMapper.map(courseDTO, Course.class);
        course.setInstructor(instructor);

        Course savedCourse = courseRepository.save(course);
        return modelMapper.map(savedCourse, CourseDTO.class);
    }

    @Override
    public CourseDTO updateCourse(Long courseId, CourseDTO courseDTO) {
        Optional<Course> existingCourseOpt = courseRepository.findById(courseId);
        if (existingCourseOpt.isEmpty()) {
            throw new RuntimeException("Course not found with ID: " + courseId);
        }

        Course existingCourse = existingCourseOpt.get();
        modelMapper.map(courseDTO, existingCourse);
        Course updatedCourse = courseRepository.save(existingCourse);

        return modelMapper.map(updatedCourse, CourseDTO.class);
    }

    @Override
    public void deleteCourse(Long courseId) {
        if (!courseRepository.existsById(courseId)) {
            throw new RuntimeException("Course not found with ID: " + courseId);
        }
        courseRepository.deleteById(courseId);
    }
}
