package com.learn.springboot.myfirstwebapp.todo;


import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

@Controller
public class TodoControllerJPA {

    @Autowired
    private TodoService todoService;

    @Autowired
    private TodoRepository todoRepository;


    @GetMapping("listTodo")
    public String getTodoByUserName(ModelMap todo, HttpSession session){
//        todo.put("todos",todoService.findByUserName(SecurityContextHolder.getContext().getAuthentication().getName()));
//        System.out.println("------------------------from-------------------"+modelMap.getAttribute("name"));

        todo.put("todos",todoRepository.findByUserName(SecurityContextHolder.getContext().getAuthentication().getName()));
        return "Todos";
    }

    @GetMapping("/add-todo")
    public String showAddTodoPage(HttpSession session){
        session.setAttribute("methodUrl", "/newTodo");
        return "AddTodo";
    }

    @PostMapping("/newTodo")
    public String addTodo(@RequestParam String description,@RequestParam LocalDate targetDate, HttpSession session){
//        todoService.addNewTodo(description, SecurityContextHolder.getContext().getAuthentication().getName(), targetDate,false);
        todoRepository.save(new Todo(SecurityContextHolder.getContext().getAuthentication().getName(), description,targetDate, false));

        return "redirect:listTodo";
    }

    @RequestMapping("/deleteTodo")
    public String deleteTodo(@RequestParam int todoId){
//        todoService.deleteTodo(todoId);
        todoRepository.deleteById(todoId);
        return "redirect:/listTodo";
    }

    @RequestMapping("/updateTodo")
    public String showUpdateTodoPage(@RequestParam Integer id, HttpSession session){
//        Todo todo = todoRepository.findById(id).get();
        System.out.println(id.getClass());
        session.setAttribute("todoId", id);
        session.setAttribute("methodUrl", "/updateTodo");
//        session.setAttribute("methodUrl", "/newTodo");
        return "AddTodo";
    }

    @PostMapping("/updateTodo")
    public String updateTodo(@RequestParam String description, @RequestParam LocalDate targetDate, HttpSession session){
//        todoService.updateTodo((int)session.getAttribute("todoId"), description, targetDate);
            Todo todo = todoRepository.findById((int) session.getAttribute("todoId")).get();
            todo.setDescription(description);
            todo.setTargetDate(targetDate);
            todoRepository.save(todo);
//        todoRepository.save(new Todo(SecurityContextHolder.getContext().getAuthentication().getName(),description, targetDate, false));
//        System.out.println("-----------------------------post update todo");
        return "redirect:/listTodo";
    }
}
