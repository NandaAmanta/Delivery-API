/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dot.test.service;

import com.dot.test.dto.CityDTO;
import com.dot.test.dto.RajaOngkirResponse;
import com.dot.test.dto.RajaOngkirResponseBody;
import com.dot.test.exception.PartnerApiException;
import com.dot.test.repository.CityRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
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

    public List<CityDTO> getCities(String provinceId) throws IOException, TimeoutException {
        RajaOngkirResponse<List<CityDTO>> response;

        if (provinceId != null) {
            response = cityRepository.findAll(provinceId);

        } else {
            response = cityRepository.findAll();
        }

        if (response.getRajaongkir().getStatus().getCode() != 200) {
            throw new PartnerApiException();
        }

        return response.getRajaongkir().getResults();
    }

    public CityDTO getCity(String cityId) throws IOException {
        RajaOngkirResponseBody response = cityRepository.findById(cityId).getRajaongkir();
        if (response.getStatus().getCode() != 200) {
            throw new PartnerApiException();
        }
        
        
        return new ObjectMapper().convertValue(response.getResults(), CityDTO.class);
    }
}
