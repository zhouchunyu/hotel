package com.example.springboot.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminIndexController {

    @RequestMapping("/admin")
    public String index() {
        return "redirect:/admin/users";
    }
}
