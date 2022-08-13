/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dot.test.service;

import com.dot.test.dto.UserDTO;
import com.dot.test.dto.UserUpdateDTO;
import com.dot.test.exception.UserNotFoundException;
import com.dot.test.model.User;
import com.dot.test.repository.UserRepository;
import com.dot.test.utils.UserMapper;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author ASUS
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException(String.format("User with email %s not exist", email)));
        UserDetails userDetails = org.springframework.security.core.userdetails.User.withUsername(user.getEmail())
                .authorities(user.getUserRole().toString())
                .accountLocked(user.getLock())
                .password(user.getPassword()).build();
        return userDetails;
    }

    @Override
    public List<UserDTO> getAllUser() {
        List<User> users = userRepository.findAll();
        if (users.isEmpty()) {
            throw new UserNotFoundException("Users Not Found");
        }
        List<UserDTO> userDTOs = UserMapper.INSTANCE.usersToUserDTOs(users);
        return userDTOs;
    }

    @Override
    public UserDTO getDetailUserById(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User not found with this Id"));
        UserDTO userDTO = UserMapper.INSTANCE.userToUserDTO(user);
        return userDTO;
    }

    @Override
    public UserDTO deleteUserById(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User not found with this Id"));
        UserDTO userDTO = UserMapper.INSTANCE.userToUserDTO(user);
        userRepository.delete(user);
        return userDTO;
    }

    /**
     *
     * @param id
     * @param userUpdateDTO
     * @return
     */
    @Override
    public UserDTO updateUserById(Long id, UserUpdateDTO userUpdateDTO) {
        User user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User not found with this Id"));
        if (userUpdateDTO.getFullName() != null) {
            user.setFullName(userUpdateDTO.getFullName());
        }

        if (userUpdateDTO.getPhoneNumber() != null) {
            user.setPhoneNumber(userUpdateDTO.getPhoneNumber());
        }

        UserDTO userDTO = UserMapper.INSTANCE.userToUserDTO(user);
        userRepository.save(user);
        return userDTO;
    }

}
