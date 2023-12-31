package com.learn.springboot.myfirstwebapp.todo;

import jakarta.persistence.*;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;

@Entity
public class Todo {

	@Id
    @SequenceGenerator(
            name = "todoId",
            sequenceName = "todoId",
            initialValue = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "todoId"
    )
    private int id;
    @Column(name = "name")
    private String userName;
    private String description;
    private LocalDate targetDate;
    private boolean done;

    public Todo( String userName, String description, LocalDate targetDate, boolean done) {
//        this.id = index;
        this.userName = userName;
        this.description = description;
        this.targetDate = targetDate;
        this.done = done;
    }

    public Todo(){}
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getTargetDate() {
        return targetDate;
    }

    public void setTargetDate(LocalDate targetDate) {
        this.targetDate = targetDate;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "id=" + id +
                ", userName=" + userName +
                ", description='" + description + '\'' +
                ", targetDate=" + targetDate +
                ", done=" + done +
                '}';
    }
}
