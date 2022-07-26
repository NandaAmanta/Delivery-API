/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dot.test.dto;

import lombok.Data;

/**
 *
 * @author ASUS
 */
@Data
public class OrderDTO {

    private Long id;
    private Integer packageWeight;
    private Integer cost;
    private String courier;
    private String recipientName;
    private String recipientNumber;
    private String destination;
    private String origin;

}
