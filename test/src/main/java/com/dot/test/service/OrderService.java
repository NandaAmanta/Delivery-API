/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dot.test.service;

import com.dot.test.dto.OrderCreationDTO;
import com.dot.test.dto.OrderDTO;
import com.dot.test.model.Order;
import com.dot.test.repository.OrderRepository;
import com.dot.test.repository.UserRepository;
import com.dot.test.utils.OrderMapper;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ASUS
 */
@Service
public class OrderService {

    @Autowired
    private ProvinceService provinceService;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserRepository userRepository;

    public OrderDTO createNewOrder(OrderCreationDTO req, String email) throws Exception {
        var origin = provinceService.getProvinceDetail(req.getOriginId());
                System.out.println("----origin------------");

        var destination = provinceService.getProvinceDetail(req.getDestinationId());
                System.out.println("----desti------------");

        var user = userRepository.findByEmail(email);

        Order order = new Order();
        order.setCost(1000);
        order.setCourier("JNT");
        order.setDestination(destination.getProvince());
        order.setOrigin(origin.getProvince());
        order.setPackageWeight(req.getPackageWeight());
        order.setRecipientName(req.getRecipientName());
        order.setRecipientNumber(req.getRecipientNumber());
        order.setStatusCode("200");
        order.setUser(user.get());

        orderRepository.save(order);
        
        System.out.println("----------------");
        
        OrderDTO orderDTO = OrderMapper.INSTANCE.OrderToOrderDTO(order);
        return orderDTO;
    }

    public List<OrderDTO> getOrders() {
        var orders = orderRepository.findAll();
        List<OrderDTO> orderDTO = OrderMapper.INSTANCE.ordersToOrderDTOs(orders);

        return orderDTO;

    }

}
