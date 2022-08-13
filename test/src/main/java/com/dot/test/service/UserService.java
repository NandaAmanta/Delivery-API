/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dot.test.service;

import com.dot.test.dto.UserDTO;
import com.dot.test.dto.UserUpdateDTO;
import java.util.List;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author ASUS
 */
@Service
public interface UserService extends UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException;

    public List<UserDTO> getAllUser();

    public UserDTO getDetailUserById(Long id);

    public UserDTO deleteUserById(Long id);

    public UserDTO updateUserById(Long id, UserUpdateDTO userUpdateDTO);
}
