package com.example.SkillSphereBackEnd.service.impl;

import com.example.SkillSphereBackEnd.dto.CourseMaterialDTO;
import com.example.SkillSphereBackEnd.entity.Course;
import com.example.SkillSphereBackEnd.entity.CourseMaterial;
import com.example.SkillSphereBackEnd.repo.CourseMaterialRepository;
import com.example.SkillSphereBackEnd.repo.CourseRepository;
import com.example.SkillSphereBackEnd.service.CourseMaterialService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CourseMaterialServiceImpl implements CourseMaterialService {

    private final CourseMaterialRepository courseMaterialRepository;
    private final CourseRepository courseRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public CourseMaterialServiceImpl(CourseMaterialRepository courseMaterialRepository, CourseRepository courseRepository, ModelMapper modelMapper) {
        this.courseMaterialRepository = courseMaterialRepository;
        this.courseRepository = courseRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public CourseMaterialDTO addCourseMaterial(CourseMaterialDTO courseMaterialDTO) {
        Optional<Course> courseOpt = courseRepository.findById(courseMaterialDTO.getCourseId());
        if (courseOpt.isEmpty()) {
            throw new RuntimeException("Course not found with ID: " + courseMaterialDTO.getCourseId());
        }

        CourseMaterial courseMaterial = modelMapper.map(courseMaterialDTO, CourseMaterial.class);
        courseMaterial.setCourse(courseOpt.get());

        CourseMaterial savedMaterial = courseMaterialRepository.save(courseMaterial);
        return modelMapper.map(savedMaterial, CourseMaterialDTO.class);
    }

    @Override
    public CourseMaterialDTO getCourseMaterialById(Long materialId) {
        Optional<CourseMaterial> materialOpt = courseMaterialRepository.findById(materialId);
        if (materialOpt.isEmpty()) {
            throw new RuntimeException("Course Material not found with ID: " + materialId);
        }
        return modelMapper.map(materialOpt.get(), CourseMaterialDTO.class);
    }

    @Override
    public List<CourseMaterialDTO> getMaterialsByCourse(Long courseId) {
        List<CourseMaterial> materials = courseMaterialRepository.findByCourseId(courseId);
        return materials.stream()
                .map(material -> modelMapper.map(material, CourseMaterialDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteCourseMaterial(Long materialId) {
        if (!courseMaterialRepository.existsById(materialId)) {
            throw new RuntimeException("Course Material not found with ID: " + materialId);
        }
        courseMaterialRepository.deleteById(materialId);
    }
}
