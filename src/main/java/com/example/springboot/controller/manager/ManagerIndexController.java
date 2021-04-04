package com.example.springboot.controller.manager;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ManagerIndexController {

    @RequestMapping("/manager")
    public String index() {
        return "redirect:/manager/hotels";
    }
}
