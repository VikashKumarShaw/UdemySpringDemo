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

    @RequestMapping(value = "/login", method = RequestMethod.GET)

    public  String  login(ModelMap model){
       // model.put("name", name);
       // System.out.println("Name is " + name);
        return "login";

    }
    @RequestMapping(value = "/login", method = RequestMethod.POST)

    public  String  welcome(ModelMap model, @RequestParam String name, @RequestParam String password){

        boolean  isValidUser = service.userValidation(name, password);

        if(!isValidUser) {
            model.put("errorMessage", "Invalid Credentials");

            return "login";
        }

        model.put("name", name);

        return "welcome";

    }


}
