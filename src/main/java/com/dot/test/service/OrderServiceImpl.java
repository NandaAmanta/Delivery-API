/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dot.test.service;

import com.dot.test.dto.OrderCreationDTO;
import com.dot.test.dto.OrderDTO;
import com.dot.test.exception.OrderNotFoundException;
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
public class OrderServiceImpl implements OrderService {

    @Autowired
    private CityService cityService;

    @Autowired
    private PricingService pricingService;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public OrderDTO createNewOrder(OrderCreationDTO req, String email) throws Exception {
        var originCity = cityService.getCity(req.getOriginCityId());
        var destinationCity = cityService.getCity(req.getDestinationCityId());
        var user = userRepository.findByEmail(email);
        var pricing = pricingService.getPricingDelivery(req.getOriginCityId(), req.getDestinationCityId(), req.getPackageWeight(), req.getCourier());

        Order order = new Order();
        order.setCost(pricing);
        order.setCourier(req.getCourier());
        order.setOrigin(String.format("%s %s, province %s", originCity.getType(), originCity.getCity_name(), originCity.getProvince()));
        order.setOriginCityId(originCity.getCity_id());
        order.setOriginProvinceId(originCity.getProvince_id());
        order.setDestination(String.format("%s %s, province %s", destinationCity.getType(), destinationCity.getCity_name(), destinationCity.getProvince()));
        order.setDestinationCityId(destinationCity.getCity_id());
        order.setDestinationProvinceId(destinationCity.getProvince_id());
        order.setPackageWeight(req.getPackageWeight());
        order.setRecipientName(req.getRecipientName());
        order.setRecipientNumber(req.getRecipientNumber());
        order.setStatusCode("200");
        order.setUser(user.get());

        orderRepository.save(order);
        OrderDTO orderDTO = OrderMapper.INSTANCE.OrderToOrderDTO(order);
        return orderDTO;
    }

    @Override
    public List<OrderDTO> getOrdersByOwner(String username) {
        var orders = userRepository.findByEmail(username).orElseThrow(() -> new OrderNotFoundException()).getOrders();
        List<OrderDTO> orderDTO = OrderMapper.INSTANCE.ordersToOrderDTOs(orders);

        return orderDTO;

    }

}
