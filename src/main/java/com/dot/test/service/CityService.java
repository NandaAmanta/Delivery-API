/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dot.test.service;

import com.dot.test.dto.CityDTO;
import java.util.List;
import org.springframework.cache.annotation.Cacheable;

/**
 *
 * @author ASUS
 */
public interface CityService {


    @Cacheable("cities")
    public List<CityDTO> getCities(String provinceId) throws Exception;

    @Cacheable("city")
    public CityDTO getCity(String cityId) throws Exception;
}
