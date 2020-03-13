package com.pack.SpringDemo.controller;

import com.pack.SpringDemo.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class LoginController {

    @Autowired
    LoginService service;

    @RequestMapping(value = "/", method = RequestMethod.GET)

    public  String  login(ModelMap model){
        model.put("name", "Vikash");
       // System.out.println("Name is " + name);
        return "welcome";

    }


}
