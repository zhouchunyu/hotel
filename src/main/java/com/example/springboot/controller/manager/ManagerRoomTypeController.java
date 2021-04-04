package com.example.springboot.controller.manager;

import com.example.springboot.mapper.RoomTypeMapper;
import com.example.springboot.model.RoomType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.inject.Inject;

@Controller
public class ManagerRoomTypeController {
    private RoomTypeMapper roomTypeMapper;

    @Inject
    public ManagerRoomTypeController(RoomTypeMapper roomTypeMapper) {
        this.roomTypeMapper = roomTypeMapper;
    }

    @RequestMapping("/manager/room_types")
    public String show(Model model) {
        model.addAttribute("roomTypes",roomTypeMapper.selectAll());
        return "roomType/index";
    }

    @RequestMapping("/manager/room_types/new")
    public String newRoomType(Model model) {
        return "roomType/new";
    }

    @RequestMapping(value = "/manager/room_types", method = RequestMethod.POST)
    public String create(RoomType roomType, Model model) {
        roomTypeMapper.create(roomType);
        model.addAttribute("roomTypes", roomTypeMapper.selectAll());
        return "roomType/index";
    }
}


