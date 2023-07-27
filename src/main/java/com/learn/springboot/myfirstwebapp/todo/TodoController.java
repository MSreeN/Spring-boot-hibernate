package com.learn.springboot.myfirstwebapp.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TodoController {

    @Autowired
    private TodoService todoService;

    @GetMapping("listTodo")
    public String getTodoByUserName(@RequestParam String userName, ModelMap todo){
        todo.put("todos",todoService.findByUserName("Sree"));
        return "Todos";
    }
}
