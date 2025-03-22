package com.example.SkillSphereBackEnd.service.impl;

import com.example.SkillSphereBackEnd.dto.UserDTO;
import com.example.SkillSphereBackEnd.entity.User;
import com.example.SkillSphereBackEnd.enums.UserRole;
import com.example.SkillSphereBackEnd.repo.UserRepository;
import com.example.SkillSphereBackEnd.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public UserDTO registerUser(UserDTO userDTO, UserRole role) {
        // Create new User without encoding password for now
        User user = modelMapper.map(userDTO, User.class);
        user.setRole(role);  // Set the role
        // Save user to the database
        user = userRepository.save(user);

        // Return DTO
        return modelMapper.map(user, UserDTO.class);
    }

    @Override
    public Optional<UserDTO> getUserByEmail(String email) {
        // Find user by email
        Optional<User> user = userRepository.findByEmail(email);
        return user.map(u -> modelMapper.map(u, UserDTO.class));
    }

    @Override
    public UserDTO updateUser(Long userId, UserDTO userDTO) {
        Optional<User> existingUserOpt = userRepository.findById(userId);
        if (existingUserOpt.isPresent()) {
            User existingUser = existingUserOpt.get();

            // Ensure ID is retained to avoid creating a new user
            modelMapper.map(userDTO, existingUser);
            existingUser.setId(userId);

            userRepository.save(existingUser); // Now it updates instead of inserting a new one

            return modelMapper.map(existingUser, UserDTO.class);
        } else {
            throw new RuntimeException("User not found with id: " + userId);
        }
    }


    @Override
    public void deleteUser(Long userId) {
        // Delete user by id
        userRepository.deleteById(userId);
    }
}
