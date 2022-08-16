/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dot.test.service;

import com.dot.test.dto.OrderCreationDTO;
import com.dot.test.dto.OrderDTO;
import java.util.List;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

/**
 *
 * @author ASUS
 */
public interface OrderService {

    @CacheEvict(value = "orders", allEntries = true)
    public OrderDTO createNewOrder(OrderCreationDTO req, String email) throws Exception ;

    @Cacheable("orders")
    public List<OrderDTO> getOrdersByOwner(String username);
}
