package com.learn.springboot.myfirstwebapp.todo;


import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.time.LocalDate;

@Controller
public class TodoController {

    @Autowired
    private TodoService todoService;


    @GetMapping("listTodo")
    public String getTodoByUserName(ModelMap todo, HttpSession session){
        session.getAttribute("name"); 
        todo.put("todos",todoService.findByUserName("Sree"));
        return "Todos";
    }

    @GetMapping("/add-todo")
    public String showAddTodoPage(){
        return "AddTodo";
    }

    @PostMapping("/newTodo")
    public String addTodo(@RequestParam String description, HttpSession session){
        todoService.addNewTodo(description, (String) session.getAttribute("name"), LocalDate.now().plusMonths(6),false);
        return "redirect:listTodo";
    }

}
