/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dot.test.service;

import com.dot.test.dto.TokenDTO;
import com.dot.test.dto.UserCreationDTO;
import com.dot.test.dto.UserDTO;
import com.dot.test.dto.UserLoginDTO;
import com.dot.test.model.User;
import com.dot.test.model.UserRole;
import com.dot.test.repository.UserRepository;
import com.dot.test.utils.JwtUtil;
import com.dot.test.utils.PasswordEncoder;
import com.dot.test.utils.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
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
    private UserService userSerivce;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    public UserDTO signUp(UserCreationDTO userCreationDTO) {
        User user = UserMapper.INSTANCE.toDomain(userCreationDTO);
        user.setPassword(passwordEncoder.getEncoder().encode(user.getPassword()));
        user.setUserRole(UserRole.USER);
        user = userRepository.save(user);
        UserDTO userDTO = UserMapper.INSTANCE.userToUserDTO(user);
        return userDTO;
    }

    public TokenDTO login(UserLoginDTO userLoginDTO) {
        authenticate(userLoginDTO.getEmail(), userLoginDTO.getPassword());
        var userDetails = userSerivce.loadUserByUsername(userLoginDTO.getEmail());
        var token = new TokenDTO(jwtUtil.generateToken(userDetails));
        return token;

    }

    private void authenticate(String username, String password) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
    }

}
