/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dot.test.controller;

import com.dot.test.dto.ResponseBody;
import com.dot.test.service.PricingService;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ASUS
 */
@RestController
@RequestMapping("/api/pricing")
public class PricingController {
    @Autowired
    private PricingService pricingService;

    @GetMapping
    public ResponseEntity<ResponseBody> checkPricing(
            @RequestParam String originCityId,
            @RequestParam String destinationCityId,
            @RequestParam String courier,
            @RequestParam String packageWeight
    ) throws IOException, Exception {
        var price = pricingService.getPricingDetail(originCityId, destinationCityId, Integer.parseInt(packageWeight), courier);
        return ResponseEntity.ok(new ResponseBody(true, "200", "Success Get price", price));
    }

}
