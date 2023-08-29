package com.learn.springboot.myfirstwebapp.todo;


import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
        todo.put("todos",todoService.findByUserName(SecurityContextHolder.getContext().getAuthentication().getName()));
//        System.out.println("------------------------from-------------------"+modelMap.getAttribute("name"));
        return "Todos";
    }

    @GetMapping("/add-todo")
    public String showAddTodoPage(HttpSession session){
        session.setAttribute("methodUrl", "/newTodo");
        return "AddTodo";
    }

    @PostMapping("/newTodo")
    public String addTodo(@RequestParam String description,@RequestParam LocalDate targetDate, HttpSession session){
        todoService.addNewTodo(description, SecurityContextHolder.getContext().getAuthentication().getName(), targetDate,false);
        return "redirect:listTodo";
    }

    @RequestMapping("/deleteTodo")
    public String deleteTodo(@RequestParam int todoId){
        todoService.deleteTodo(todoId);
        return "redirect:/listTodo";
    }

    @RequestMapping("/updateTodo")
    public String showUpdateTodoPage(@RequestParam Integer id, HttpSession session){
        Todo todo = todoService.getTodoById(id);
        System.out.println(id.getClass());
        session.setAttribute("todoId", id);
        session.setAttribute("methodUrl", "/updateTodo");
//        session.setAttribute("methodUrl", "/newTodo");
        return "AddTodo";
    }

    @PostMapping("/updateTodo")
    public String updateTodo(@RequestParam String description, @RequestParam LocalDate targetDate, HttpSession session){
        todoService.updateTodo((int)session.getAttribute("todoId"), description, targetDate);
        System.out.println("-----------------------------post update todo");
        return "redirect:/listTodo";
    }
}
