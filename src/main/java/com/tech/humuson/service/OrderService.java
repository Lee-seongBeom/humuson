package com.tech.humuson.service;

import java.util.List;

import com.tech.humuson.dto.OrderDto;

public interface OrderService {

    List<OrderDto> getOrder();      // 주문 조회

    void addOrder(OrderDto order);  // 주문 추가
    
}
