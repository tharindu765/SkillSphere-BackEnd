package com.example.SkillSphereBackEnd.service.impl;

import com.example.SkillSphereBackEnd.dto.CertificateDTO;
import com.example.SkillSphereBackEnd.entity.Certificate;
import com.example.SkillSphereBackEnd.entity.Course;
import com.example.SkillSphereBackEnd.entity.Student;
import com.example.SkillSphereBackEnd.repo.CertificateRepository;
import com.example.SkillSphereBackEnd.repo.CourseRepository;
import com.example.SkillSphereBackEnd.repo.StudentRepository;
import com.example.SkillSphereBackEnd.service.CertificateService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CertificateServiceImpl implements CertificateService {

    @Autowired
    private CertificateRepository certificateRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CertificateDTO generateCertificate(Long studentId, Long courseId, String certificateUrl) {
        Optional<Student> studentOpt = studentRepository.findById(studentId);
        Optional<Course> courseOpt = courseRepository.findById(courseId);

        if (studentOpt.isPresent() && courseOpt.isPresent()) {
            Certificate certificate = new Certificate();
            certificate.setStudent(studentOpt.get());
            certificate.setCourse(courseOpt.get());
            certificate.setCertificateUrl(certificateUrl);
            certificate.setIssuedAt(LocalDateTime.now());

            Certificate savedCertificate = certificateRepository.save(certificate);
            return modelMapper.map(savedCertificate, CertificateDTO.class);
        } else {
            throw new RuntimeException("Student or Course not found.");
        }
    }

    @Override
    public CertificateDTO getCertificateById(Long certificateId) {
        Certificate certificate = certificateRepository.findById(certificateId)
                .orElseThrow(() -> new RuntimeException("Certificate not found"));
        return modelMapper.map(certificate, CertificateDTO.class);
    }

    @Override
    public List<CertificateDTO> getCertificatesByStudent(Long studentId) {
        List<Certificate> certificates = certificateRepository.findByStudentId(studentId);
        return certificates.stream()
                .map(cert -> modelMapper.map(cert, CertificateDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<CertificateDTO> getCertificatesByCourse(Long courseId) {
        List<Certificate> certificates = certificateRepository.findByCourseId(courseId);
        return certificates.stream()
                .map(cert -> modelMapper.map(cert, CertificateDTO.class))
                .collect(Collectors.toList());
    }
}
