/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dot.test.dto;

import java.util.List;
import lombok.Data;

/**
 *
 * @author ASUS
 */
@Data
public class CourierService {

    private String service;
    private String description;
    private List<CourierServicePricing> cost;
}
