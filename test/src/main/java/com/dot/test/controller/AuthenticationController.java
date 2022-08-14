/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dot.test.controller;

import com.dot.test.dto.ResponseBody;
import com.dot.test.dto.UserCreationDTO;
import com.dot.test.dto.UserDTO;
import com.dot.test.dto.UserLoginDTO;
import com.dot.test.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ASUS
 */
@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {

    @Autowired
    private AuthService authService;

    @PostMapping(path = "/signup")
    public ResponseEntity<ResponseBody> signUpUser(@RequestBody UserCreationDTO userCreationDTO) {
        UserDTO userDTO = authService.signUp(userCreationDTO);
        
        return ResponseEntity.ok(new ResponseBody(true, "200", "Success add new user", userDTO));
    }

    @PostMapping(path = "/login")
    public ResponseEntity<ResponseBody> login(@RequestBody UserLoginDTO userLoginDTO) {
        var token = authService.login(userLoginDTO);
        return ResponseEntity.ok(new ResponseBody(true, "200", "Success Generate Token", token));
    }

}
