/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dot.test.service;

import com.dot.test.dto.CourierDTO;
import com.dot.test.dto.CourierServicePricing;
import com.dot.test.exception.CourierNotFoundException;
import com.dot.test.exception.PartnerApiException;
import com.dot.test.repository.PricingRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 * @author ASUS
 */
@Service
public class PricingServiceImpl implements PricingService {

    @Autowired
    private PricingRepository pricingRepository;

    public int getPricingDelivery(String originCityId, String destinationCityId, int packageWeight, String courier) throws IOException {
        return getPricing(originCityId, destinationCityId, packageWeight, courier).getValue();
    }

    public CourierServicePricing getPricingDetail(String originCityId, String destinationCityId, int packageWeight, String courier) throws IOException {
        return getPricing(originCityId, destinationCityId, packageWeight, courier);
    }

    private CourierServicePricing getPricing(String originCityId, String destinationCityId, int packageWeight, String courier) throws IOException {
        var response = pricingRepository.getPricing(
                Integer.parseInt(originCityId), Integer.parseInt(destinationCityId), packageWeight, courier);
        if (response.getRajaongkir().getStatus().getCode() == 400) {
            throw new CourierNotFoundException();
        } else if (response.getRajaongkir().getStatus().getCode() != 200) {
            throw new PartnerApiException();
        }

        List result = new ObjectMapper().convertValue(response.getRajaongkir().getResults(), ArrayList.class);
        List<CourierDTO> listCourier = new ArrayList();
        for (var indexObject : result) {
            var mapped = new ObjectMapper().convertValue(indexObject, CourierDTO.class);
            listCourier.add(mapped);
        }

        var price = listCourier.get(0).getCosts()
                .stream()
                .filter(c -> "REG".equals(c.getService()))
                .findFirst()
                .map(mapper -> mapper.getCost().get(0))
                .orElseThrow(() -> new CourierNotFoundException());

        return price;
    }
}
