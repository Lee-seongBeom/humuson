package com.tech.humuson.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
	 * @param Model model
	 * @return void
	 * @throws Exception
	 */
    @RequestMapping("/get")
    public void getOrder(Model model) throws Exception{
        List<OrderDto> orderList = orderService.getOrder();
        model.addAttribute("orderList", orderList);
    }
    
    /**
     * 주문ID를 통해 주문 조회
     *
     * @param OrderDto order
     * @return 
     * @throws Exception
     */
    @RequestMapping("/getOrderById")
    public void getOrderById(Model model) throws Exception{
        List<OrderDto> orderList = orderService.getOrder();
        // model.addAttribute("orderList", orderList);

    }

    /**
     * 주문 추가
	 *
     * @param OrderDto order
     * @return ResponseEntity
     * @throws Exception
	 */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<String> addOrder(OrderDto order){
        try {
            orderService.addOrder(order);
            return ResponseEntity.ok("주문 추가 성공");
            
        } catch (Exception e) {
            return ResponseEntity.status(500).body("주문 추가 실패");
        }
    }
    
}
