package com.example.springboot.controller.manager;

import com.example.springboot.mapper.HotelMapper;
import com.example.springboot.model.Hotel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.inject.Inject;

@Controller
class ManagerHotelController {
    private HotelMapper hotelMapper;

    @Inject
    public ManagerHotelController(HotelMapper hotelMapper) {
        this.hotelMapper = hotelMapper;
    }

    @RequestMapping(value = "/manager/hotels", method = RequestMethod.POST)
    public String create(Hotel hotel, Model model) {
        int success = hotelMapper.create(hotel);
        model.addAttribute("hotels", hotelMapper.selectAll());
        return "hotel/index";
    }

    @RequestMapping("/manager/hotels")
    public String show(Model model) {
        model.addAttribute("hotels",hotelMapper.selectAll());
        return "hotel/index";
    }

    @RequestMapping("/manager/hotels/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        Hotel hotel = hotelMapper.find(id);
        model.addAttribute("hotel", hotel);
        return "hotel/edit";
    }

    @RequestMapping(value = "/manager/hotels/{id}", method = RequestMethod.POST)
    public String update(Hotel hotel , @PathVariable("id") int id, Model model) {
        hotel.setId(id);
        int success = hotelMapper.update(hotel);
        model.addAttribute("hotels", hotelMapper.selectAll());
        return "hotel/index";
    }


    @RequestMapping("/manager/hotels/new")
    public String newHotel(Model model) {
        Hotel hotel = new Hotel();
        hotel.setStarRating("3星");
        model.addAttribute("hotel", hotel);
        return "/hotel/new";
    }


}
