package com.example.springboot.controller;

import com.example.springboot.mapper.HotelMapper;
import com.example.springboot.mapper.RoomTypeMapper;
import com.example.springboot.model.Hotel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.inject.Inject;

@Controller
public class RoomTypeController {
    private RoomTypeMapper roomTypeMapper;
    private HotelMapper hotelMapper;

    @Inject
    public RoomTypeController(RoomTypeMapper roomTypeMapper, HotelMapper hotelMapper) {
        this.roomTypeMapper = roomTypeMapper;
        this.hotelMapper = hotelMapper;
    }

    @RequestMapping("/hotels/{id}/room_types")
    public String index(Model model, @PathVariable("id") int hotelId) {
        model.addAttribute("hotel", hotelMapper.find(hotelId));
        model.addAttribute("roomTypes",roomTypeMapper.selectByHotelId(hotelId));
        return "roomType/user_index";
    }
}

