/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dot.test.service;

import com.dot.test.dto.CourierServicePricing;
import org.springframework.cache.annotation.Cacheable;

/**
 *
 * @author ASUS
 */
public interface PricingService {
    
    @Cacheable("pricing")
    public int getPricingDelivery(String originCityId, String destinationCityId, int packageWeight, String courier) throws Exception;
    
    @Cacheable("pricing")
    public CourierServicePricing getPricingDetail(String originCityId, String destinationCityId, int packageWeight, String courier) throws Exception;
 
}
