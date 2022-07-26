/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dot.test.controller;

import com.dot.test.dto.Response;
import com.dot.test.dto.UserCreationDTO;
import com.dot.test.dto.UserDTO;
import com.dot.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ASUS
 */
@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService UserService;

    @PostMapping
    public Response<UserDTO> addNewUser(@RequestBody UserCreationDTO userCreationDTO) {
        UserDTO userDTO = UserService.addNewUser(userCreationDTO);
        return new Response(true, "200", "Success adding new user", userDTO);
    }

}
