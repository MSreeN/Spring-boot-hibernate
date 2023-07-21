package com.learn.springboot.myfirstwebapp.login;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
    @RequestMapping("/greet")
    public String loginGreeting(@RequestParam(value = "name", defaultValue = "mahesh") String userName, ModelMap modelMap){
        modelMap.put("name", userName);
        return "Greet";
    }
}
