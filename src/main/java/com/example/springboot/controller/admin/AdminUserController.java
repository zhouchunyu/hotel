package com.example.springboot.controller.admin;

import com.example.springboot.mapper.HotelMapper;
import com.example.springboot.mapper.UserMapper;
import com.example.springboot.model.User;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.inject.Inject;
@Controller
public class AdminUserController {
    private UserMapper userMapper;
    private HotelMapper hotelMapper;
    private AuthenticationManager authenticationManager;

    @Inject
    public AdminUserController(UserMapper userMapper, HotelMapper hotelMapper, AuthenticationManager authenticationManager) {
        this.userMapper = userMapper;
        this.hotelMapper = hotelMapper;
        this.authenticationManager = authenticationManager;
    }

//    @RequestMapping(value = "/users", method = RequestMethod.POST)
//    public String create(User user, Model model, HttpServletRequest request) {
//        int success = userMapper.create(user);
//        userMapper.create_authorities(user);
//        if(success == 1){
//            UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword());
//            authToken.setDetails(new WebAuthenticationDetails(request));
//            Authentication authentication = authenticationManager.authenticate(authToken);
//            SecurityContextHolder.getContext().setAuthentication(authentication);
//            model.addAttribute("hotels", hotelMapper.selectAll());
//            return "hotel/user_index";
//        }
//        return "login";
//    }
    @RequestMapping("/admin/users")
    public String index(Model model) {
        model.addAttribute("users", userMapper.selectAll());
        return "user/admin_index";
    }

    @RequestMapping("/admin/users/{username}/edit")
    public String edit(@PathVariable("username")String username, Model model){
        model.addAttribute("user", userMapper.findByName(username));
        return "user/edit";
    }

    @RequestMapping(value = "/admin/users/{username}",method = RequestMethod.POST)
    public String update(@PathVariable("username")String username, String password){
        User user = userMapper.findByName(username);
        user.setPassword(password);
        int success = userMapper.update(user);
        return "redirect:/admin/users";
    }

}
