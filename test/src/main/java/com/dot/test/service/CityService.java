/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dot.test.service;

import com.dot.test.dto.CityDTO;
import com.dot.test.exception.CityNotFoundException;
import com.dot.test.repository.CityRepository;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeoutException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ASUS
 */
@Service
public class CityService {

    @Autowired
    private CityRepository cityRepository;

    public List<CityDTO> getCities() throws IOException, TimeoutException {
        var response = cityRepository.findAll();

        if (response.getRajaongkir().getStatus().getCode() == 404) {
            throw new CityNotFoundException();

        } else if (response.getRajaongkir().getStatus().getCode() == 408) {
            throw new TimeoutException();
        
        }

        return response.getRajaongkir().getResults();
    }
}
