package com.example.SkillSphereBackEnd.service.impl;

import com.example.SkillSphereBackEnd.dto.EnrollmentDTO;
import com.example.SkillSphereBackEnd.entity.Course;
import com.example.SkillSphereBackEnd.entity.Enrollment;
import com.example.SkillSphereBackEnd.entity.Student;
import com.example.SkillSphereBackEnd.repo.CourseRepository;
import com.example.SkillSphereBackEnd.repo.EnrollmentRepository;
import com.example.SkillSphereBackEnd.repo.StudentRepository;
import com.example.SkillSphereBackEnd.service.EnrollmentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EnrollmentServiceImpl implements EnrollmentService {

    @Autowired
    private EnrollmentRepository enrollmentRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public EnrollmentDTO enrollStudent(Long studentId, Long courseId) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found"));
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Course not found"));

        Enrollment enrollment = new Enrollment();
        enrollment.setStudent(student);
        enrollment.setCourse(course);
        enrollment.setEnrollmentDate(LocalDateTime.now());
        enrollment.setCompleted(false);  // Default false

        enrollment = enrollmentRepository.save(enrollment);
        return modelMapper.map(enrollment, EnrollmentDTO.class);
    }

    @Override
    public List<EnrollmentDTO> getEnrollmentsByStudent(Long studentId) {
        List<Enrollment> enrollments = enrollmentRepository.findByStudentId(studentId);
        return enrollments.stream()
                .map(enrollment -> modelMapper.map(enrollment, EnrollmentDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<EnrollmentDTO> getEnrollmentsByCourse(Long courseId) {
        List<Enrollment> enrollments = enrollmentRepository.findByCourseId(courseId);
        return enrollments.stream()
                .map(enrollment -> modelMapper.map(enrollment, EnrollmentDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public void markCourseCompleted(Long enrollmentId) {
        Enrollment enrollment = enrollmentRepository.findById(enrollmentId)
                .orElseThrow(() -> new RuntimeException("Enrollment not found"));

        enrollment.setCompleted(true);
        enrollmentRepository.save(enrollment);

        // Update Student progress
        Student student = enrollment.getStudent();
        student.setProgress(100.0);  // Set progress to 100%
        studentRepository.save(student);
    }
}
