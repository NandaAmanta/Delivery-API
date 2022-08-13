/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dot.test.service;

import com.dot.test.dto.TokenDTO;
import com.dot.test.dto.UserCreationDTO;
import com.dot.test.dto.UserDTO;
import com.dot.test.dto.UserLoginDTO;

/**
 *
 * @author ASUS
 */
public interface AuthService {


    public UserDTO signUp(UserCreationDTO userCreationDTO) ;

    public TokenDTO login(UserLoginDTO userLoginDTO) ;

}
