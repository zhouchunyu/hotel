package com.example.springboot.controller.manager;

import com.example.springboot.mapper.UserMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.inject.Inject;

@Controller
public class ManagerUserController {
    private UserMapper userMapper;

    @Inject
    public ManagerUserController(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @RequestMapping("/manager/users")
    public String show(Model model) {
        model.addAttribute("users",userMapper.selectAll());
        return "user/index";
    }

}
