package com.pack.SpringDemo.service;

import com.pack.SpringDemo.model.Todo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Service
public class TodoService {
    private static List<Todo> todos = new ArrayList<Todo>();
    private static int todoCount = 3;

    static {
        todos.add(new Todo(1, "Vikash", "Learn Spring MVC", new Date(),
                false));
        todos.add(new Todo(2, "Vikash", "Learn Struts", new Date(), false));
        todos.add(new Todo(3, "Vikash", "Learn Hibernate", new Date(),
                false));
    }

    public List<Todo> retrieveTodos(String user) {
        List<Todo> filteredTodos = new ArrayList<Todo>();
        for (Todo todo : todos) {
            if (todo.getUser().equals(user)) {
                filteredTodos.add(todo);
            }
        }
        return filteredTodos;
    }
    public Todo  updateTodos(int id) {
        for (Todo todo : todos) {
            if (todo.getId() == id) {

                return todo;
            }
        }
        return null;
    }
    public void updateTodoList(Todo todo){

        todos.remove(todo);
        todos.add(todo);

    }

    public void addTodo(String name, String desc, Date targetDate,
            boolean isDone) {
        todos.add(new Todo(++todoCount, name, desc, targetDate, isDone));
    }

    public void deleteTodo(int id) {
        todos.removeIf(todo -> todo.getId() == id);
    }
}