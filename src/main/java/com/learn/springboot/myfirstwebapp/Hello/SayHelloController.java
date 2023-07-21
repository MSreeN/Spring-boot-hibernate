package com.learn.springboot.myfirstwebapp.Hello;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SayHelloController {

    @RequestMapping("/say-hello")
    @ResponseBody
    public String sayHello(){
        return "first method";
    }

    @RequestMapping("/say-jsp")
    public String sayHelloJsp(){
        return "SayHello";
    }

    @RequestMapping("/login")
    public String loginJsp(){
        return "Login";
    }
}
