package com.example.SkillSphereBackEnd.service.impl;

import com.example.SkillSphereBackEnd.dto.CourseDTO;
import com.example.SkillSphereBackEnd.dto.InstructorDTO;
import com.example.SkillSphereBackEnd.entity.Course;
import com.example.SkillSphereBackEnd.entity.Instructor;
import com.example.SkillSphereBackEnd.enums.UserRole;
import com.example.SkillSphereBackEnd.repo.CourseRepository;
import com.example.SkillSphereBackEnd.repo.InstructorRepository;
import com.example.SkillSphereBackEnd.service.InstructorService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class InstructorServiceImpl implements InstructorService {

    @Autowired
    private InstructorRepository instructorRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public InstructorDTO registerInstructor(InstructorDTO instructorDTO) {
        Instructor instructor = modelMapper.map(instructorDTO, Instructor.class);
        instructor.setRole(UserRole.INSTRUCTOR);
        if (instructor.getEarnings() == null) {
            instructor.setEarnings(0.0); // Default earnings to 0.0
        }
        Instructor savedInstructor = instructorRepository.save(instructor);
        return modelMapper.map(savedInstructor, InstructorDTO.class);
    }

    @Override
    public InstructorDTO getInstructorDetails(Long instructorId) {
        Optional<Instructor> instructor = instructorRepository.findById(instructorId);
        return instructor.map(i -> modelMapper.map(i, InstructorDTO.class))
                         .orElseThrow(() -> new RuntimeException("Instructor not found with id: " + instructorId));
    }

    @Override
    public InstructorDTO updateInstructorDetails(Long instructorId, InstructorDTO instructorDTO) {
        Optional<Instructor> optionalInstructor = instructorRepository.findById(instructorId);
        if (optionalInstructor.isPresent()) {
            Instructor existingInstructor = optionalInstructor.get();

            // Use ModelMapper but prevent null values from overwriting existing fields
            modelMapper.getConfiguration().setSkipNullEnabled(true);
            modelMapper.map(instructorDTO, existingInstructor);

            // 🔥 Always set the role to INSTRUCTOR, even if the DTO does not contain it
            existingInstructor.setRole(UserRole.INSTRUCTOR);

            instructorRepository.save(existingInstructor);
            return modelMapper.map(existingInstructor, InstructorDTO.class);
        } else {
            throw new RuntimeException("Instructor not found with ID: " + instructorId);
        }
    }

    @Override
    public CourseDTO createCourse(Long instructorId, CourseDTO courseDTO) {
        Optional<Instructor> instructorOpt = instructorRepository.findById(instructorId);
        if (instructorOpt.isEmpty()) {
            throw new RuntimeException("Instructor not found with ID: " + instructorId);
        }

        Instructor instructor = instructorOpt.get(); // Fetch existing instructor

        Course course = modelMapper.map(courseDTO, Course.class);
        course.setInstructor(instructor); // Set instructor properly

        Course savedCourse = courseRepository.save(course);
        return modelMapper.map(savedCourse, CourseDTO.class);
    }

    @Override
    public List<CourseDTO> getInstructorCourses(Long instructorId) {
        Instructor instructor = instructorRepository.findById(instructorId)
                .orElseThrow(() -> new RuntimeException("Instructor not found"));

        List<Course> courses = courseRepository.findByInstructor(instructor);
        return courses.stream()
                .map(course -> modelMapper.map(course, CourseDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public CourseDTO updateCourse(Long instructorId, Long courseId, CourseDTO courseDTO) {
        // Fetch the existing course from the database
        Course existingCourse = courseRepository.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Course not found with ID: " + courseId));

        // Ensure that the course belongs to the correct instructor
        if (!existingCourse.getInstructor().getId().equals(instructorId)) {
            throw new RuntimeException("Course does not belong to the specified instructor.");
        }

        // Update fields without creating a new instance
        existingCourse.setTitle(courseDTO.getTitle());
        existingCourse.setDescription(courseDTO.getDescription());
        existingCourse.setPrice(courseDTO.getPrice());
        existingCourse.setCategory(courseDTO.getCategory()); // Ensure category is updated

        // Save the updated course (Hibernate will recognize it as an update)
        Course updatedCourse = courseRepository.save(existingCourse);

        return modelMapper.map(updatedCourse, CourseDTO.class);
    }

    @Override
    public void deleteCourse(Long instructorId, Long courseId) {
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Course not found"));

        if (!course.getInstructor().getId().equals(instructorId)) {
            throw new RuntimeException("You are not authorized to delete this course");
        }

        courseRepository.delete(course);
    }
}
