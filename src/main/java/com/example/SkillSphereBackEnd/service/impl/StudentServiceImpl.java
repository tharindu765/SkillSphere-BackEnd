package com.example.SkillSphereBackEnd.service.impl;

import com.example.SkillSphereBackEnd.dto.CourseDTO;
import com.example.SkillSphereBackEnd.dto.EnrollmentDTO;
import com.example.SkillSphereBackEnd.dto.StudentDTO;
import com.example.SkillSphereBackEnd.entity.Course;
import com.example.SkillSphereBackEnd.entity.Enrollment;
import com.example.SkillSphereBackEnd.entity.Student;
import com.example.SkillSphereBackEnd.enums.UserRole;
import com.example.SkillSphereBackEnd.repo.CourseRepository;
import com.example.SkillSphereBackEnd.repo.EnrollmentRepository;
import com.example.SkillSphereBackEnd.repo.StudentRepository;
import com.example.SkillSphereBackEnd.service.StudentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private EnrollmentRepository enrollmentRepository; // Handle enrollment

    @Autowired
    private ModelMapper modelMapper;

    // ✅ Register Student
    @Override
    public StudentDTO registerStudent(StudentDTO studentDTO) {
        Student student = modelMapper.map(studentDTO, Student.class);
        student.setRole(UserRole.STUDENT);
        student = studentRepository.save(student);
        return modelMapper.map(student, StudentDTO.class);
    }

    // ✅ Get Student Details
    @Override
    public StudentDTO getStudentDetails(Long studentId) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found with ID: " + studentId));
        return modelMapper.map(student, StudentDTO.class);
    }

    // ✅ Enroll in Course
    @Override
    public EnrollmentDTO enrollInCourse(Long studentId, Long courseId) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found!"));

        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Course not found!"));

        Enrollment enrollment = new Enrollment();
        student.setProgress(0.0);
        enrollment.setStudent(student);
        enrollment.setCourse(course);
        enrollment.setEnrollmentDate(LocalDateTime.now());
        enrollment.setCompleted(false);


        enrollment = enrollmentRepository.save(enrollment);

        return new EnrollmentDTO(
                enrollment.getId(),
                studentId,
                courseId,
                enrollment.getEnrollmentDate(),
                enrollment.getCompleted()
        );
    }

    // ✅ Get Enrolled Courses
    @Override
    public List<CourseDTO> getEnrolledCourses(Long studentId) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found!"));

        List<Enrollment> enrollments = enrollmentRepository.findByStudentId(studentId);

        return enrollments.stream()
                .map(enrollment -> modelMapper.map(enrollment.getCourse(), CourseDTO.class))
                .collect(Collectors.toList());
    }

    // ✅ Get Progress
    @Override
    public Double getProgress(Long studentId) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found!"));
        return student.getProgress();
    }

    // ✅ Get Certificates Earned
    @Override
    public Integer getCertificatesEarned(Long studentId) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found!"));
        return student.getCertificatesEarned();
    }
}
