package com.learn.springboot.myfirstwebapp.todo;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class TodoService {

    private static final List<Todo> todos;
    static{
        todos = new ArrayList<Todo>();
        todos.add(new Todo("Sree", "complete web", LocalDate.now().plusYears(1), false));
        todos.add(new Todo("Sree", "complete java", LocalDate.now().plusMonths(5),false));
        todos.add(new Todo("Sree", "wash clothes", LocalDate.now().plusMonths(5),false));
    }

    public List<Todo> findByUserName(String userName){
        return todos;
    }

}
