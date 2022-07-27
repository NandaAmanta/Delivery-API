/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dot.test.service;

import com.dot.test.dto.UserCreationDTO;
import com.dot.test.dto.UserDTO;
import com.dot.test.model.User;
import com.dot.test.model.UserRole;
import com.dot.test.repository.UserRepository;
import com.dot.test.utils.PasswordEncoder;
import com.dot.test.utils.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ASUS
 */
@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;
    
    public UserDTO signUp(UserCreationDTO userCreationDTO) {
        User user = UserMapper.INSTANCE.toDomain(userCreationDTO);
        user.setPassword(passwordEncoder.getEncoder().encode(user.getPassword()));
        user.setUserRole(UserRole.USER);
        user = userRepository.save(user);
        UserDTO userDTO = UserMapper.INSTANCE.userToUserDTO(user);
        return userDTO;
    }

}
