package com.learn.springboot.myfirstwebapp.todo;

import jakarta.servlet.http.HttpSession;
import org.eclipse.tags.shaded.org.apache.xpath.operations.Bool;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
public class TodoService {

    private static List<Todo> todos;
    private static int count = 0;
    static{
        todos = new ArrayList<Todo>();
        todos.add(new Todo(  "Sree", "complete web", LocalDate.now().plusYears(1), false));
        todos.add(new Todo("Sree", "complete java", LocalDate.now().plusMonths(5),false));
        todos.add(new Todo("Sree", "wash clothes", LocalDate.now().plusMonths(5),false));
    }

    public List<Todo> findByUserName(String userName){
        Predicate<Todo> findTodoByUserName =
                todo -> todo.getUserName().equalsIgnoreCase(userName);
        return todos.stream().filter(findTodoByUserName).collect(Collectors.toList());
    }

    public void addNewTodo(String description, String username, LocalDate localDate, boolean isDone){
        todos.add(new Todo( username, description,localDate, isDone));
//        return todos;
    }

    public void deleteTodo(int todoId){
        Predicate<Todo> gonnaBeDeletedTodo = todo -> todo.getId() == todoId;
        todos.removeIf(gonnaBeDeletedTodo);
    }

    public Todo getTodoById(int id) {
        Predicate<Todo> findTodo = todo -> todo.getId() == id;
        Todo todo = todos.stream().filter(findTodo).findFirst().get();
        return todo;
    }

    public void updateTodo(int todoId, String description, LocalDate targetDate){
        Todo todo = getTodoById(todoId);
        todo.setDescription(description);
        todo.setTargetDate(targetDate);
    }
}
