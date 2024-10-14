package com.tech.humuson.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tech.humuson.dto.OrderDto;
import com.tech.humuson.service.OrderService;

@RestController
@RequestMapping("/api/order")
public class ApiController {

    @Autowired
    private OrderService orderService;

    /**
	 * 주문 조회
	 *
	 * @param OrderDto order
	 * @return 
	 * @throws Exception
	 */
    @RequestMapping("/get")
    public String getOrder(Model model) throws Exception{
        List<OrderDto> orderList = orderService.getOrder();
        model.addAttribute("orderList", orderList);
        return "orderList";
    }

    /**
	 * 주문 추가
	 *
	 * @param OrderDto order
	 * @return orderService.getOrder 주문 리스트
	 * @throws Exception
	 */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public void addOrder(OrderDto order) throws Exception{
        orderService.addOrder(order);
    }
    
}
