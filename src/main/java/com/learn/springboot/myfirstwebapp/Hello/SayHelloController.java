package com.learn.springboot.myfirstwebapp.Hello;


import com.fasterxml.jackson.annotation.JsonView;
import com.learn.springboot.myfirstwebapp.login.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@SessionAttributes("name")
public class SayHelloController {

    @Autowired
    private AuthenticationService authenticationService;

    @RequestMapping("/say-hello")
    @ResponseBody
    public String sayHello(){
        return "first method";
    }

    @RequestMapping("/say-jsp")
    public String sayHelloJsp(){
        return "SayHello";
    }

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String loginJsp(){
        return "Login";
    }

    @PostMapping("/login")
    public String goToWelcomePage(@RequestParam String username, @RequestParam String password, ModelMap params){
        if(authenticationService.authenticate(username, password)){
            params.put("name", username);
            params.put("password", password);
            return "Welcome";
        }
        else{
            params.put("error", "Invalid Credentials");
            return "login";
        }
    }
}
