/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dot.test.utils;

import com.dot.test.dto.OrderDTO;
import com.dot.test.dto.UserCreationDTO;
import com.dot.test.dto.UserDTO;
import com.dot.test.model.Order;
import com.dot.test.model.User;
import java.util.List;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

/**
 *
 * @author ASUS
 */
@Mapper
public interface OrderMapper {

    
    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    Order toDomain(OrderDTO orderDTO);
    
    @Named("toDTO")
    OrderDTO OrderToOrderDTO(Order order);
    
    @IterableMapping(qualifiedByName = "toDTO")
    List<OrderDTO> ordersToOrderDTOs(List<Order> order);
}
