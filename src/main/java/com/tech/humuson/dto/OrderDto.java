package com.tech.humuson.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OrderDto {
    private String orderId;     // 주문 ID
    private String orderName;   // 주문 고객명
    private String orderDate;   // 주문 날짜
    private String orderType;   // 주문 상태 (처리중, 배송중, 완료)

}
