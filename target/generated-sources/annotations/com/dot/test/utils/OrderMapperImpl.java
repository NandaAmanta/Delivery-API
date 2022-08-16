package com.dot.test.utils;

import com.dot.test.dto.OrderDTO;
import com.dot.test.model.Order;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-16T12:03:27+0800",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 11.0.11 (AdoptOpenJDK)"
)
public class OrderMapperImpl implements OrderMapper {

    @Override
    public Order toDomain(OrderDTO orderDTO) {
        if ( orderDTO == null ) {
            return null;
        }

        Order order = new Order();

        order.setId( orderDTO.getId() );
        order.setPackageWeight( orderDTO.getPackageWeight() );
        order.setCost( orderDTO.getCost() );
        order.setCourier( orderDTO.getCourier() );
        order.setRecipientName( orderDTO.getRecipientName() );
        order.setDestination( orderDTO.getDestination() );
        order.setOrigin( orderDTO.getOrigin() );
        order.setRecipientNumber( orderDTO.getRecipientNumber() );

        return order;
    }

    @Override
    public OrderDTO OrderToOrderDTO(Order order) {
        if ( order == null ) {
            return null;
        }

        OrderDTO orderDTO = new OrderDTO();

        orderDTO.setId( order.getId() );
        orderDTO.setPackageWeight( order.getPackageWeight() );
        orderDTO.setCost( order.getCost() );
        orderDTO.setCourier( order.getCourier() );
        orderDTO.setRecipientName( order.getRecipientName() );
        orderDTO.setRecipientNumber( order.getRecipientNumber() );
        orderDTO.setDestination( order.getDestination() );
        orderDTO.setOrigin( order.getOrigin() );

        return orderDTO;
    }

    @Override
    public List<OrderDTO> ordersToOrderDTOs(List<Order> order) {
        if ( order == null ) {
            return null;
        }

        List<OrderDTO> list = new ArrayList<OrderDTO>( order.size() );
        for ( Order order1 : order ) {
            list.add( OrderToOrderDTO( order1 ) );
        }

        return list;
    }
}
