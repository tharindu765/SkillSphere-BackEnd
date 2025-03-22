package com.example.SkillSphereBackEnd.controller;

import com.example.SkillSphereBackEnd.dto.CertificateDTO;
import com.example.SkillSphereBackEnd.service.CertificateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/certificates")
public class CertificateController {

    @Autowired
    private CertificateService certificateService;

    @PostMapping("/generate")
    public ResponseEntity<CertificateDTO> generateCertificate(
            @RequestParam Long studentId,
            @RequestParam Long courseId,
            @RequestParam String certificateUrl) {
        CertificateDTO certificate = certificateService.generateCertificate(studentId, courseId, certificateUrl);
        return ResponseEntity.ok(certificate);
    }

    @GetMapping("/{certificateId}")
    public ResponseEntity<CertificateDTO> getCertificateById(@PathVariable Long certificateId) {
        CertificateDTO certificate = certificateService.getCertificateById(certificateId);
        return ResponseEntity.ok(certificate);
    }

    @GetMapping("/student/{studentId}")
    public ResponseEntity<List<CertificateDTO>> getCertificatesByStudent(@PathVariable Long studentId) {
        List<CertificateDTO> certificates = certificateService.getCertificatesByStudent(studentId);
        return ResponseEntity.ok(certificates);
    }

    @GetMapping("/course/{courseId}")
    public ResponseEntity<List<CertificateDTO>> getCertificatesByCourse(@PathVariable Long courseId) {
        List<CertificateDTO> certificates = certificateService.getCertificatesByCourse(courseId);
        return ResponseEntity.ok(certificates);
    }
}
