package com.learn.springboot.myfirstwebapp.todo;

import java.time.LocalDate;
import java.util.List;

public class TodoService {

    private static List<Todo> todos;
    static{
        todos.add(new Todo("Sree", "complete web", LocalDate.now().plusYears(1), false));
        todos.add(new Todo("nag", "complete java", LocalDate.now().plusMonths(5),false));
        todos.add(new Todo("mahesh", "wash clothes", LocalDate.now().plusMonths(5),false));

    }
}
