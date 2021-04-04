package com.example.springboot.controller;

import com.example.springboot.mapper.HotelMapper;
import com.example.springboot.mapper.OrderMapper;
import com.example.springboot.mapper.RoomTypeMapper;
import com.example.springboot.model.Hotel;
import com.example.springboot.model.Order;
import com.example.springboot.model.RoomType;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;

import javax.inject.Inject;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class OrderController {
    private OrderMapper orderMapper;
    private HotelMapper hotelMapper;
    private RoomTypeMapper roomTypeMapper;

    @Inject
    public OrderController(OrderMapper orderMapper, HotelMapper hotelMapper, RoomTypeMapper roomTypeMapper) {
        this.orderMapper = orderMapper;
        this.hotelMapper = hotelMapper;
        this.roomTypeMapper = roomTypeMapper;
    }

    @RequestMapping("/orders")
    public String index(Model model) {
        model.addAttribute("orders",orderMapper.selectAll());
        return "order/user_index";
    }

    @RequestMapping("/orders/new_order")
    public String newOrder(int hotelId, Model model) {
        Hotel hotel = hotelMapper.find(hotelId);
        List<RoomType> roomTypeList = this.roomTypeMapper.selectByHotelId(hotelId);
        model.addAttribute("hotel", hotel);
        model.addAttribute("roomTypeList", roomTypeList);
        return "order/new";
    }

    @RequestMapping(value = "/orders", method = RequestMethod.POST)
    public String create(Order order, Authentication authentication, Model model) {
        order.setUsername(authentication.getName());
        orderMapper.create(order);
        model.addAttribute("order", orderMapper.selectAll());
        return "redirect:/orders";
    }

    @InitBinder
    public void initBinder(WebDataBinder binder, WebRequest request) {
        //转换日期 注意这里的转化要和传进来的字符串的格式一直 如2015-9-9 就应该为yyyy-MM-dd
        String pattern="yyyy-MM-dd'T'HH:mm";
        DateFormat dateFormat=new SimpleDateFormat(pattern);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));// CustomDateEditor为自定义日期编辑器
    }

}
