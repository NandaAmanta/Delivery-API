/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dot.test.controller;

import com.dot.test.dto.ResponseBody;
import com.dot.test.dto.UserDTO;
import com.dot.test.dto.UserUpdateDTO;
import com.dot.test.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ASUS
 */
@RestController
@PreAuthorize("hasRole('ADMIN')")
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService UserService;

    @GetMapping
    public ResponseEntity<ResponseBody<UserDTO>> getUsers() {
        List<UserDTO> userDTOs = UserService.getAllUser();
        return ResponseEntity.ok(new ResponseBody(true, "200", "Success Get users", userDTOs));
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<ResponseBody<UserDTO>> getDetailUser(@PathVariable String id) {
        UserDTO userDTO = UserService.getDetailUserById(Long.parseLong(id));
        return ResponseEntity.ok(new ResponseBody(true, "200", "Success Get detail user", userDTO));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<ResponseBody<UserDTO>> deleteUser(@PathVariable String id) {
        UserDTO userDTO = UserService.deleteUserById(Long.parseLong(id));
        return ResponseEntity.ok(new ResponseBody(true, "200", "Success delete user", userDTO));
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<ResponseBody<UserDTO>> editUser(@PathVariable String id, @RequestBody UserUpdateDTO userUpdateDTO) {
        UserDTO userDTO = UserService.updateUserById(Long.parseLong(id), userUpdateDTO);
        return ResponseEntity.ok(new ResponseBody(true, "200", "Success edit user", userDTO));
    }

}
