package com.example.SkillSphereBackEnd.service;

import com.example.SkillSphereBackEnd.dto.CertificateDTO;

import java.util.List;

public interface CertificateService {
    CertificateDTO generateCertificate(Long studentId, Long courseId, String certificateUrl); // Generate a certificate
    CertificateDTO getCertificateById(Long certificateId); // Get certificate by ID
    List<CertificateDTO> getCertificatesByStudent(Long studentId); // Get certificates for a student
    List<CertificateDTO> getCertificatesByCourse(Long courseId); // Get certificates for a course
}
