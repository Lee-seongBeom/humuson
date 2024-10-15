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
    public List<OrderDto> getOrder() throws Exception{
        return orderList;
    }
    
    // 주문 추가
    @Override
    public void addOrder(List<OrderDto> addList) throws Exception{
        if(addList !=null && !addList.isEmpty()){
            orderList.addAll(addList);
        }else{
            throw new Exception("주문 추가 실패");
        }

    }

    // 주문ID 검색 후 리스트 반환
    @Override
    public List<OrderDto> getSearchId(String id) throws Exception{
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
