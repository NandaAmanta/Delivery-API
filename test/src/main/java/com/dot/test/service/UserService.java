/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dot.test.service;

import com.dot.test.dto.UserCreationDTO;
import com.dot.test.dto.UserDTO;
import com.dot.test.exception.UserNotFoundException;
import com.dot.test.model.User;
import com.dot.test.repository.UserRepository;
import com.dot.test.utils.UserMapper;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ASUS
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserDTO addNewUser(UserCreationDTO userCreationDTO) {
        User user = UserMapper.INSTANCE.toDomain(userCreationDTO);
        user = userRepository.save(user);
        UserDTO userDTO = UserMapper.INSTANCE.userToUserDTO(user);
        return userDTO;
    }

    public List<UserDTO> getAllUser() {
        List<User> users = userRepository.findAll();
        List<UserDTO> userDTOs = UserMapper.INSTANCE.usersToUserDTOs(users);
        return userDTOs;
    }

    public UserDTO getDetailUser(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User not found with this Id"));
        UserDTO userDTO = UserMapper.INSTANCE.userToUserDTO(user);
        return userDTO;
    }
}
