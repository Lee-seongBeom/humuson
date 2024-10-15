package com.tech.humuson.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.tech.humuson.dto.OrderDto;

@Service
public class OrderServiceImpl implements OrderService{
    
    private List<OrderDto> orderList = new ArrayList<>();

    
    // 주문 조회
    @Override
    public List<OrderDto> getOrder(){
        return orderList;
    }
    
    // 주문 추가
    @Override
    public void addOrder(OrderDto order){
        orderList.add(order);
    }

    // 주문ID 검색 후 리스트 반환
    @Override
    public List<OrderDto> getSearchId(String id){
        List<OrderDto> orderList = getOrder();
        List<OrderDto> filterList = new ArrayList<>();

        for (OrderDto val : orderList) {
            if (val.getOrderId().contains(id)) {    // 필터링 조건
                filterList.add(val);
            }
        }
        return filterList;
    };

}
