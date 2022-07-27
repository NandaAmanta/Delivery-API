/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dot.test.controller;

import com.dot.test.dto.ResponseBody;
import com.dot.test.dto.UserDTO;
import com.dot.test.service.ProvinceService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ASUS
 */
@RestController
@RequestMapping("/api/data")
public class DataController {

    @Autowired
    private ProvinceService provinceService;

    @GetMapping(path = "/provinces")
    public ResponseEntity<ResponseBody> getProvinces() throws Exception {
        var provinces = provinceService.getProvinces();
        return ResponseEntity.ok(new ResponseBody(true, "200", "Success Get users", provinces));
    }

}
