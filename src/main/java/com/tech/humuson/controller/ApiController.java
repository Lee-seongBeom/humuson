package com.tech.humuson.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tech.humuson.dto.OrderDto;
import com.tech.humuson.service.OrderService;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/api/order")
public class ApiController {

    @Autowired
    private OrderService orderService;

    /**
	 * 주문 조회 api
	 *
	 * @param Model model
	 * @return List<OrderDto>
	 * @throws Exception
	 */
    @RequestMapping("/get")
    public List<OrderDto> getOrder(Model model) throws Exception{
        return orderService.getOrder();
    }
    
    /**
     * 주문 추가 api
     *
     * @param List<OrderDto> addList
     * @return ResponseEntity<String>
     * 
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<String> addOrder(@Valid @RequestBody List<OrderDto> addList){
        try {
            orderService.addOrder(addList);
            return ResponseEntity.ok("주문 추가 성공");
            
        } catch (Exception e) {
            return ResponseEntity.status(500).body("주문 추가 실패");
        }
    }

    /**
     * 주문ID 검색 조회 api
     *
     * @param String id
     * @return List<OrderDto>
     * @throws Exception
     */
    @RequestMapping("/getSearchId")
    public List<OrderDto> getSearchId(String id) throws Exception{
        return orderService.getSearchId(id);
    }

    /**
     * 외부시스템으로 데이터 전송 api
     *
     * @param String id
     * @return List<OrderDto>
     * @throws Exception
     */
    @RequestMapping("/sendData")
    public String sendData(String param) throws Exception{
        return new String();
    }
    
    /**
     * 전송 데이터 확인 api
     *
     * @param String id
     * @return List<OrderDto>
     * @throws Exception
     */
    @RequestMapping("/checkData")
    public String checkData(String param) {
        return new String();
    }
    

    
}
