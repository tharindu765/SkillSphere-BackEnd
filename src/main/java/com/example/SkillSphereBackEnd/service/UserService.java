package com.example.SkillSphereBackEnd.service;

import com.example.SkillSphereBackEnd.dto.UserDTO;
import com.example.SkillSphereBackEnd.enums.UserRole;

import java.util.Optional;

public interface UserService {
    UserDTO registerUser(UserDTO userDTO, UserRole role); // Register a new user with a role
    Optional<UserDTO> getUserByEmail(String email); // Get user by email
    UserDTO updateUser(Long userId, UserDTO userDTO); // Update user details
    void deleteUser(Long userId); // Delete a user
}
