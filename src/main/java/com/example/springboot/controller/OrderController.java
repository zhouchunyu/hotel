package com.example.springboot.controller;

import com.example.springboot.mapper.OrderMapper;
import com.example.springboot.model.Order;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.inject.Inject;

@Controller
public class OrderController {
    private OrderMapper orderMapper;

    @Inject
    public OrderController(OrderMapper orderMapper) {
        this.orderMapper = orderMapper;
    }

    @RequestMapping("/orders")
    public String index(Model model) {
        model.addAttribute("orders",orderMapper.selectAll());
        return "order/index";
    }

    @RequestMapping("/orders/newOrder")
    public String newOrder(Model model) {
        return "order/new";
    }

    @RequestMapping("/orders/create")
    public String newOrder(Order order, Model model) {
        orderMapper.create(order);
        model.addAttribute("order", orderMapper.selectAll());
        return "order/index";
    }

}
