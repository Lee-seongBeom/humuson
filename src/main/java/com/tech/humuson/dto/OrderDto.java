package com.tech.humuson.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OrderDto {

    @NotBlank(message = "주문 ID가 비었습니다.")
    @NotNull(message = "주문 ID가 없습니다.")
    private String orderId;     // 주문 ID
    
    @NotBlank(message = "고객명가 비었습니다.")
    @NotNull(message = "고객명가 없습니다.")
    private String orderName;   // 주문 고객명
    
    @NotBlank(message = "주문 날짜가 비었습니다.")
    @NotNull(message = "주문 날짜가 없습니다.")
    private String orderDate;   // 주문 날짜
    
    @NotBlank(message = "주문 상태가 비었습니다.")
    @NotNull(message = "주문 상태가 없습니다.")
    private String orderType;   // 주문 상태 (처리중, 배송중, 완료)

}
