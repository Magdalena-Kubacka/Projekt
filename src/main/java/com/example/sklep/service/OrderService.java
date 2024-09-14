package com.example.sklep.service;

import com.example.sklep.Cart;
import com.example.sklep.dto.OrderDto;
import com.example.sklep.mapper.OrderMapper;
import com.example.sklep.model.order.Order;
import com.example.sklep.repository.order.OrderItemRepository;
import com.example.sklep.repository.order.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
  private final Cart cart;
  private final OrderRepository orderRepository;
  private final OrderItemRepository orderItemRepository;

  @Autowired
  public OrderService(Cart cart, OrderRepository orderRepository, OrderItemRepository orderItemRepository) {
    this.cart = cart;
    this.orderRepository = orderRepository;
    this.orderItemRepository = orderItemRepository;
  }
  public void saveOrder(OrderDto orderDto) {
    Order order = OrderMapper.mapToOrder(orderDto);
    orderRepository.save(order);
    orderItemRepository.saveAll(OrderMapper.mapToOrderItemList(cart, order));
    cart.cleanCart();



}}
