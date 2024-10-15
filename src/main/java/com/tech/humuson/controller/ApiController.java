package com.tech.humuson.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public List<OrderDto> getOrder() throws Exception{
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
            return ResponseEntity.status(500).body("네트워크 오류로 주문 추가 실패");
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
     * 외부시스템으로 json형식 데이터 전송 api
     *
     * @param List<OrderDto> jsonOrderList
     * @return ResponseEntity<String>
     * @throws Exception
     */
    @RequestMapping("/sendData")
    public ResponseEntity<String> sendData(@RequestBody List<OrderDto> jsonOrderList) throws Exception{
        try {
            String jsonString = orderService.stringToJson(jsonOrderList);
            return ResponseEntity.ok(jsonString);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("네트워크 오류로 데이터 전송 실패");
        }
    }
    
    /**
     * 리스트 형식으로 데이터 전송 api
     *
     * @param List<OrderDto> orderList
     * @return ResponseEntity<String>
     * @throws Exception
     */
    @RequestMapping("/jsonToList")
    public ResponseEntity<String> jsonToList(@RequestBody List<OrderDto> orderList) throws Exception{
        try {
            return ResponseEntity.ok(orderList.toString());
        } catch (Exception e) {
            return ResponseEntity.status(500).body("네트워크 오류로 데이터 전송 실패");
        }
    }
    

    
}
