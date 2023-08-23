package com.learn.springboot.myfirstwebapp.login;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
    @RequestMapping("/")
    public String Greeting(ModelMap modelMap){
        modelMap.put("name", "Sree");
        return "Welcome";
    }
}
