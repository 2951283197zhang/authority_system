package com.hopu.controller;

import com.hopu.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/user")
public class LoginController {

    @PostMapping(value="/login")
    public String login(String email,String password){
        return "admin/index";    //TODO
    }

    @RequestMapping("/logout")
    public String logout(){
        return "forward:/login.jsp";
    }
}
