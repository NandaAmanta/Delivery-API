/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dot.test.service;

import com.dot.test.dto.ProvinceDTO;
import com.dot.test.dto.RajaOngkirResponseBody;
import com.dot.test.repository.ProvinceRepository;
import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ASUS
 */
@Service
public class ProvinceService {

    @Autowired
    private ProvinceRepository provinceRepository;

    public List<ProvinceDTO> getProvinces() throws IOException, Exception {
        RajaOngkirResponseBody<List<ProvinceDTO>> response = provinceRepository.findAll().getRajaongkir();
        if (response.getStatus().getCode() != 200) {
            throw new Exception(response.getStatus().getDescription());
        }
        
        return response.getResults();
        
    }
}
