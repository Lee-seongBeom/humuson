package com.tech.humuson.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tech.humuson.dto.OrderDto;
import com.tech.humuson.service.OrderService;


@Controller
public class MainController {

    @Autowired
    private OrderService orderService;
    
    @RequestMapping("/")
    public String main(Model model) throws Exception{
        
        List<OrderDto> orderList = orderService.getOrder();
        model.addAttribute("orderList", orderList);
        
        return "index";
    }
    
}
