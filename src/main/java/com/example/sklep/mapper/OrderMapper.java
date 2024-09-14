package com.example.sklep.mapper;

import com.example.sklep.Cart;
import com.example.sklep.CartItem;
import com.example.sklep.dto.OrderDto;
import com.example.sklep.model.order.Order;
import com.example.sklep.model.order.OrderItem;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class OrderMapper {
  public static Order mapToOrder(OrderDto orderDto) {
    return Order.builder()
      .firstName(orderDto.getFirstName())
      .lastName(orderDto.getLastName())
      .address(orderDto.getAddress())
      .postCode(orderDto.getPostCode())
      .city(orderDto.getCity())
      .created(LocalDateTime.now())
      .build();
  }

  public static List<OrderItem> mapToOrderItemList(Cart cart, Order order) {
    List<OrderItem> orderItems = new ArrayList<>();
    for(CartItem ci: cart.getCartItems()) {
      orderItems.add(new OrderItem(order.getOrderId(), ci.getItem().getId(), ci.getCounter()));
    }
    return orderItems;
  }

}
