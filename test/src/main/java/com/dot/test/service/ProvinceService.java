/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dot.test.service;

import com.dot.test.dto.ProvinceDTO;
import com.dot.test.dto.RajaOngkirResponseBody;
import com.dot.test.exception.PartnerApiException;
import com.dot.test.repository.ProvinceRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 *
 * @author ASUS
 */
@Service
public class ProvinceService {

    @Autowired
    private ProvinceRepository provinceRepository;

    @Cacheable("provinces")
    public List<ProvinceDTO> getProvinces() throws IOException, Exception {
        RajaOngkirResponseBody<List<ProvinceDTO>> response = provinceRepository.findAll().getRajaongkir();
        if (response.getStatus().getCode() != 200) {
            throw new PartnerApiException();
        }

        return response.getResults();
    }

    public ProvinceDTO getProvinceDetail(String id) throws IOException, Exception {
        RajaOngkirResponseBody response = provinceRepository.findById(id).getRajaongkir();
        if (response.getStatus().getCode() != 200) {
            throw new PartnerApiException();
        }
        return new ObjectMapper().convertValue(response.getResults(), ProvinceDTO.class);

    }
}
