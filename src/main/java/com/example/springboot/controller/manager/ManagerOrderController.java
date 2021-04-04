package com.example.springboot.controller.manager;

import com.example.springboot.mapper.OrderMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.inject.Inject;

@Controller
public class ManagerOrderController {
    private OrderMapper orderMapper;

    @Inject
    public ManagerOrderController(OrderMapper orderMapper) {
        this.orderMapper = orderMapper;
    }

    @RequestMapping("/manager/orders")
    public String show(Model model) {
        model.addAttribute("orders",orderMapper.selectAll());
        return "order/index";
    }

}
