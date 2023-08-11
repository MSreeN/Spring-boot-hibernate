package com.learn.springboot.myfirstwebapp.todo;


import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

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
    public String showAddTodoPage(HttpSession session){
        session.setAttribute("methodUrl", "/newTodo");
        return "AddTodo";
    }

    @PostMapping("/newTodo")
    public String addTodo(@RequestParam String description, HttpSession session){
        todoService.addNewTodo(description, (String) session.getAttribute("name"), LocalDate.now().plusMonths(6),false);
        return "redirect:listTodo";
    }

    @RequestMapping("/deleteTodo")
    public String deleteTodo(@RequestParam int todoId){
        todoService.deleteTodo(todoId);
        return "redirect:/listTodo";
    }

    @GetMapping("/updateTodo")
    public String showUpdateTodoPage(@RequestParam int id, HttpSession session){
        Todo todo = todoService.getTodoById(id);
        session.setAttribute("todoId", id);
        session.setAttribute("methodUrl", "/updateTodo");
//        session.setAttribute("methodUrl", "/newTodo");
        return "AddTodo";
    }

    @PostMapping("/updateTodo")
    public String updateTodo(@RequestParam String description, HttpSession session){
        todoService.updateTodo((int)session.getAttribute("todoId"), description);
        return "redirect:/listTodo";
    }
}
