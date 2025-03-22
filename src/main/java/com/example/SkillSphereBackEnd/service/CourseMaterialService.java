package com.example.SkillSphereBackEnd.service;

import com.example.SkillSphereBackEnd.dto.CourseMaterialDTO;
import java.util.List;

public interface CourseMaterialService {
    CourseMaterialDTO addCourseMaterial(CourseMaterialDTO courseMaterialDTO);
    CourseMaterialDTO getCourseMaterialById(Long materialId);
    List<CourseMaterialDTO> getMaterialsByCourse(Long courseId);
    void deleteCourseMaterial(Long materialId);
}
