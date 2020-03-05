package com.pack.SpringDemo.service;

import org.springframework.stereotype.Component;

@Component
public class LoginService {

    public boolean userValidation(String userId, String password) {

        return userId.equalsIgnoreCase("Vikash") && password.equalsIgnoreCase("dummy");
    }
}
