package com.learn.springboot.myfirstwebapp.todo;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class TodoService {

    private static List<Todo> todos;
    private static int count = 0;
    static{
        todos = new ArrayList<Todo>();
        todos.add(new Todo(++count  ,"Sree", "complete web", LocalDate.now().plusYears(1), false));
        todos.add(new Todo(++count,"Sree", "complete java", LocalDate.now().plusMonths(5),false));
        todos.add(new Todo(++count,"Sree", "wash clothes", LocalDate.now().plusMonths(5),false));
    }

    public List<Todo> findByUserName(String userName){
        return todos;
    }

    public void addNewTodo(String description, String username, LocalDate localDate, boolean isDone){
        todos.add(new Todo(++count, username, description,localDate, isDone));
//        return todos;
    }

    public void deleteTodo(int todoId){

    }

}
