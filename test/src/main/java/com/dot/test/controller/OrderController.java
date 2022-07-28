/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dot.test.controller;

import com.dot.test.dto.OrderCreationDTO;
import com.dot.test.dto.ResponseBody;
import com.dot.test.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ASUS
 */
@RestController
@RequestMapping("/api/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public ResponseEntity<ResponseBody> createNewOrder(@RequestBody OrderCreationDTO req, Authentication auth) throws Exception {
        var orderDTO = orderService.createNewOrder(req, auth.getName());
        return ResponseEntity.ok(new ResponseBody(true, "200", "Success create new order", orderDTO));
    }

    @GetMapping
    public ResponseEntity<ResponseBody> createNewOrder() throws Exception {
        var orderDTOs = orderService.getOrders();
        return ResponseEntity.ok(new ResponseBody(true, "200", "Success get orders", orderDTOs));
    }

}
