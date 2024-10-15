package com.tech.humuson.service;

import java.util.List;

import com.tech.humuson.dto.OrderDto;

public interface OrderService {

    // 주문 조회
    List<OrderDto> getOrder();

    // 주문 추가
    void addOrder(OrderDto order);

    // 주문ID 검색 조회
    List<OrderDto> getSearchId(String id);
    
}
