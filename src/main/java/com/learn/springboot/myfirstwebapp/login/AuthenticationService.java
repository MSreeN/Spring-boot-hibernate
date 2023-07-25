package com.learn.springboot.myfirstwebapp.login;

import org.springframework.stereotype.Component;

@Component
public class AuthenticationService {

    public boolean authenticate(String name, String password){
        boolean isNameValid = name.equalsIgnoreCase("sree");
        boolean isPassValid = password.equalsIgnoreCase("sree");
        return isNameValid && isPassValid;
    }

}
