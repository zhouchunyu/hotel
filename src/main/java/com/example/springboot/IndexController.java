package com.example.springboot;

import com.example.springboot.mapper.HotelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.inject.Inject;

@Controller

public class IndexController {
    private HotelMapper hotelMapper;

    @Inject
    public IndexController(HotelMapper hotelMapper){
        this.hotelMapper = hotelMapper;
    }


    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("hotels", hotelMapper.selectAll());
        return "/hotel/user_index";
    }

}