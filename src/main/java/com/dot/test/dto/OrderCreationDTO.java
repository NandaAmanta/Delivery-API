/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dot.test.dto;

import javax.validation.constraints.NotNull;
import lombok.Data;

/**
 *
 * @author ASUS
 */
@Data
public class OrderCreationDTO {

    @NotNull
    private Integer packageWeight;
    @NotNull
    private String courier;
    @NotNull
    private String recipientName;
    @NotNull
    private String recipientNumber;
    @NotNull
    private String destinationCityId;
    @NotNull
    private String originCityId;

}
