package com.tech.humuson.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.tech.humuson.dto.OrderDto;

@Service
public class OrderServiceImpl implements OrderService{
    
    private List<OrderDto> orderList = new ArrayList<>();

    @Override
    public List<OrderDto> getOrder(){
        return orderList;
    }

    @Override
    public void addOrder(OrderDto order){
        orderList.add(order);
    }
}
