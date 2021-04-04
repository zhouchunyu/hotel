package com.example.springboot.controller.manager;

import com.example.springboot.mapper.RoomTypeMapper;
import com.example.springboot.model.Hotel;
import com.example.springboot.model.RoomType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
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

    @RequestMapping(value = "/manager/room_types/{id}", method = RequestMethod.POST)
    public String update(RoomType roomType, @PathVariable("id") int id, Model model) {
        roomType.setId(id);
        roomTypeMapper.update(roomType);
        return "redirect:/manager/room_types";
    }

    @RequestMapping("/manager/room_types/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        RoomType roomType = roomTypeMapper.find(id);
        model.addAttribute("roomType", roomType);
        return "roomType/edit";
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


