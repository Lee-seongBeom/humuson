package com.tech.humuson.service;

import java.util.List;

import com.tech.humuson.dto.OrderDto;

public interface OrderService {

    // 주문 조회
    List<OrderDto> getOrder() throws Exception;

    // 주문 추가
    void addOrder(List<OrderDto> addList) throws Exception;

    // 주문ID 검색 조회
    List<OrderDto> getSearchId(String id) throws Exception;

    // toString() 방식을 json형식으로 변환
    String stringToJson(List<OrderDto> jsonList) throws Exception;

    // json 형식의 문자열을 이스케이프 문자열로 변환
    String escapeString(String jsonStr) throws Exception;

    // 이스케이프 문자열을 리스트 형식으로 변환
    List<OrderDto> listStr(String escapStr) throws Exception;

}
