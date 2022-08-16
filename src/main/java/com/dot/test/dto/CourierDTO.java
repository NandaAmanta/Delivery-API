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
public class CourierDTO {

    private String code;
    private String name;
    private List<CourierService> costs;
}
