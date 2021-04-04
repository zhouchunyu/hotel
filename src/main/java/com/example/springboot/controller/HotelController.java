package com.example.springboot.controller;


import com.example.springboot.mapper.HotelMapper;
import com.example.springboot.model.Hotel;
import com.example.springboot.util.JsonResult;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.inject.Inject;

@Controller
public class HotelController {
    private HotelMapper hotelMapper;

    @Inject
    public HotelController(HotelMapper hotelMapper) {
        this.hotelMapper = hotelMapper;
    }

    @RequestMapping("/hotels")

    public String index(Model model) {
        model.addAttribute("hotels",hotelMapper.selectAll());
        return "hotel/user_index";
    }
}
