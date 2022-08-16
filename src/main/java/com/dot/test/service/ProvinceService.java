/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dot.test.service;

import com.dot.test.dto.ProvinceDTO;
import java.io.IOException;
import java.util.List;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 *
 * @author ASUS
 */
@Service
public interface ProvinceService {

    @Cacheable("provinces")
    public List<ProvinceDTO> getProvinces() throws IOException, Exception;

    public ProvinceDTO getProvinceDetail(String id) throws IOException, Exception ;
}
