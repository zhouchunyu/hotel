package com.example.springboot.controller;

import com.example.springboot.mapper.HotelMapper;
import com.example.springboot.mapper.UserMapper;

import com.example.springboot.model.User;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

@Controller
public class UserController {
    private UserMapper userMapper;
    private HotelMapper hotelMapper;
    private AuthenticationManager authenticationManager;

    @Inject
    public UserController(UserMapper userMapper, HotelMapper hotelMapper, AuthenticationManager authenticationManager) {
        this.userMapper = userMapper;
        this.hotelMapper = hotelMapper;
        this.authenticationManager = authenticationManager;
    }

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public String create(User user, Model model, HttpServletRequest request) {
        int success = userMapper.create(user);
        userMapper.create_authorities(user);
        if(success == 1){
            UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword());
            authToken.setDetails(new WebAuthenticationDetails(request));
            Authentication authentication = authenticationManager.authenticate(authToken);
            SecurityContextHolder.getContext().setAuthentication(authentication);
            model.addAttribute("hotels", hotelMapper.selectAll());
            return "hotel/user_index";
        }
        return "login";
    }
}
